package distancecalculator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import distancecalculator.dao.CityDistanceDao;
import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.rest.dto.CityRestDto;
import distancecalculator.rest.dto.DistanceRequest;
import distancecalculator.rest.dto.XmlDto;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import distancecalculator.utils.Calculator;
import distancecalculator.utils.converters.CsvFileParser;
import distancecalculator.utils.converters.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DataGenerator {
    @Autowired
    private CityDistanceDao dao;

    public static void main(String[] args) throws Exception {
        //GeneratorTestData generatorTestData = new GeneratorTestData();
        //generatorTestData.createFileFrom("citiest.csv");
    }

    public void createFileFrom(String fileName) throws Exception {
        List<City> cityList = CsvFileParser.readFromCSV(fileName, ';');
        dao.saveCityList(cityList);
        XmlDto xmlDto = new XmlDto();
        xmlDto.insertCityList(cityList);
        File file = new File("./test2.xml");
        XmlService.marshalInFile(xmlDto, file, XmlDto.class);
    }

    public void generate() throws Exception {
        List<City> citylist = CsvFileParser.readFromCSV("cities1k.csv", ';');
        dao.saveCityList(citylist);
        List<Distance> randDistanceList = DataGenerator.getRandomSet(citylist, 10_000);
        dao.saveDistanceList(randDistanceList);
        XmlDto xmlDto = new XmlDto(citylist, randDistanceList);
        File file = new File("src/test/httpreqwests/smalltest.xml");
        XmlService.marshalInFile(xmlDto, file, XmlDto.class);
        InputStream inputStream = new FileInputStream(file);
        XmlDto xmlDto1 = XmlService.unMarshal(inputStream, XmlDto.class);
        System.out.println(xmlDto1.getCityDtoMap().size());
    }

    private static List<Distance> getRandomSet(List<City> list, int quantity) {
        List<Distance> distanceList = new ArrayList<>(quantity);
        List<City> toList = new ArrayList<>(list);
        Collections.shuffle(toList);
        Random random = new Random();
        int toIndex = 0;
        City toCity = null;
        for (City city : list) {
            for (int i = 0; i < quantity / (list.size() - 1); i++) {
                do {
                    toIndex = random.nextInt(toList.size());
                    toCity = toList.get(toIndex);
                }
                while (city.equals(toCity));
                distanceList.add(Calculator.calculate(city, toCity));
            }
        }
        return distanceList;
    }

    public String jsonT() throws DistanceCalculatorException, JsonProcessingException {

        List<City> fromCitylist = new ArrayList<>();
        List<City> toCityList = new ArrayList<>();
        fromCitylist.add(dao.getById(2));
        fromCitylist.add(dao.getById(3));
        fromCitylist.add(dao.getById(4));
        toCityList.add(dao.getById(5));
        toCityList.add(dao.getById(6));
        toCityList.add(dao.getById(7));
        toCityList.add(dao.getById(8));
        List<CityRestDto> fromCitiesRes = fromCitylist.stream().map(c -> new CityRestDto(c)).collect(Collectors.toList());
        List<CityRestDto> toCitiesRest = toCityList.stream().map(c -> new CityRestDto(c)).collect(Collectors.toList());
        for (City fromCity : fromCitylist) {
            for (City toCity : toCityList) {
                if (!fromCity.equals(toCity)) {
                    dao.saveDistance(new Distance(fromCity, toCity, Calculator.calculate(fromCity, toCity).getDistance() + 7));
                }
            }
        }
        DistanceRequest distanceRequest = new DistanceRequest();
        distanceRequest.setCalculationType("CROW_FLIGHT");
        distanceRequest.setFromCities(fromCitiesRes);
        distanceRequest.setToCities(toCitiesRest);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(distanceRequest);
        return jsonString;
    }
}
