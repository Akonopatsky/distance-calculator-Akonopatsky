package distancecalculator.utils;

import distancecalculator.dao.CityDistanceDao;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import distancecalculator.rest.dto.XmlDto;
import distancecalculator.utils.converters.CsvFileParser;
import distancecalculator.utils.converters.XmlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DataGeneratorTest {
    @Autowired
    CityDistanceDao dao;


    public void createFileFrom(String fileName) throws Exception {
        List<City> cityList = CsvFileParser.readFromCSV(fileName, ';');
        dao.saveCityList(cityList);
        XmlDto xmlDto = new XmlDto();
        xmlDto.insertCityList(cityList);
        File file = new File("./test2.xml");
        XmlService.marshalInFile(xmlDto, file, XmlDto.class);
    }

    @Test
    public void generate() throws Exception {
        List<City> cityList = CsvFileParser.readFromCSV("cities1k.csv", ';');
        dao.saveCityList(cityList);
        List<Distance> randDistanceList = getRandomSet(cityList, 10_000);
        dao.saveDistanceList(randDistanceList);
        XmlDto xmlDto = new XmlDto(cityList, randDistanceList);
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
}