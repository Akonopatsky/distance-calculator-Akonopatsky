package distancecalculator.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import distancecalculator.dao.CityDistanceDao;
import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.rest.dto.CityRestDto;
import distancecalculator.rest.dto.DistanceRequest;
import distancecalculator.rest.dto.XmlDto;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import distancecalculator.utils.converters.CsvFileParser;
import distancecalculator.utils.converters.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

@Component
public class GeneratorTestData {
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
        List<City> citylist = CsvFileParser.readFromCSV("cities10k.csv", ';');
        dao.saveCityList(citylist);
        List<Distance> randDistanceList = GeneratorTestData.getRandomSet(citylist, 1_000_000);
        XmlDto xmlDto = new XmlDto(citylist, randDistanceList);
        File file = new File("bigtest.xml");
        XmlService.marshalInFile(xmlDto, file, XmlDto.class);
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
                distanceList.add(CalculateService.calculate(city, toCity));
            }
        }
        return distanceList;
    }

    public String jsont() throws DistanceCalculatorException, JsonProcessingException {
        City city1 = dao.getById(2);
        City city2 = dao.getById(3);
        City city3 = dao.getById(4);
        CityRestDto cityRestDto1 = new CityRestDto(city1);
        CityRestDto cityRestDto2 = new CityRestDto(city2);
        CityRestDto cityRestDto3 = new CityRestDto(city3);
        List<CityRestDto> fromCities = new ArrayList<>();
        fromCities.add(cityRestDto1);
        fromCities.add(cityRestDto2);
        fromCities.add(cityRestDto3);
        List<CityRestDto> toCities = new ArrayList<>(fromCities);
        DistanceRequest distanceRequest = new DistanceRequest();
        distanceRequest.setCalculationType("CROW_FLIGHT");
        distanceRequest.setFromCities(fromCities);
        distanceRequest.setToCities(toCities);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(distanceRequest);
        return jsonString;
    }
}
