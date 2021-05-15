package distancecalculator.utils;

import distancecalculator.dao.CityDistanceDao;
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
        GeneratorTestData generatorTestData = new GeneratorTestData();
        generatorTestData.createFileFrom("citiest.csv");
    }

    public void createFileFrom(String fileName) throws Exception {
        List<City> cityList = CsvFileParser.readFromCSV(fileName, ';');
        dao.saveCityList(cityList);
        XmlDto xmlDto = new XmlDto();
        xmlDto.insertCityList(cityList);
        File file = new File("./test2.xml");
        XmlService.marshalInFile(xmlDto, file);
    }

    public void generate() throws Exception{
        List<City> city500list = CsvFileParser.readFromCSV("citiest.csv", ';');
        dao.saveCityList(city500list);
        List<Distance> randDistanceList = GeneratorTestData.getRandomSet(city500list, city500list.size() / 2);
        XmlDto xmlDto = new XmlDto(city500list, randDistanceList);
        File file = new File("bigtest.xml");
        XmlService.marshalInFile(xmlDto, file);
    }

    private static List<Distance> getRandomSet(List<City> list, int quantity) {
        List<Distance> distanceList = new ArrayList<>(quantity);
        List<City> fromList = new ArrayList<>(list);
        List<City> toList = new ArrayList<>(list);
        Collections.shuffle(fromList);
        Collections.shuffle(toList);
        for (int i = 0; i < quantity; i++) {
            int fromIndex = toList.size() - 1;
            int toIndex = toList.size() - 1;
            City fromCity = fromList.get(fromIndex);
            City toCity = toList.get(toIndex);
            while (fromCity.equals(toCity)) {
                toIndex--;
                toCity = toList.get(toIndex);
            }
            distanceList.add(CalculateService.calculate(fromCity, toCity));
            fromList.remove(fromIndex);
            toList.remove(toIndex);
        }
        return distanceList;
    }
}
