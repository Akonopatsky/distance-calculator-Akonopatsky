package distancecalculator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import distancecalculator.dao.CityDistanceDao;
import distancecalculator.dao.DistanceRepository;
import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import distancecalculator.rest.dto.CalculationType;
import distancecalculator.rest.dto.CityRestDto;
import distancecalculator.rest.dto.DistanceRequest;
import distancecalculator.rest.dto.XmlDto;
import distancecalculator.utils.Calculator;
import distancecalculator.utils.converters.XmlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class Generator {

    @Autowired
    private CityDistanceDao dao;

    @Autowired
    private DistanceRepository distanceRepository;

    @Test
    public void generateXml() throws DistanceCalculatorException, JAXBException {
        XmlDto xmlDto = new XmlDto();
        List<City> cityList = dao.getAllCities();
        List<Distance> distanceList = (List<Distance>) distanceRepository.findAll();
        xmlDto.insertCityList(cityList);
        xmlDto.insertDistanceList(distanceList);
        File file = new File("src/test/httpreqwests/smalltest2.xml");
        XmlService.marshalInFile(xmlDto, file, XmlDto.class);
    }


    @Test
    public void generate() throws DistanceCalculatorException, JsonProcessingException {
        List<City> fromCityList = new ArrayList<>();
        List<City> toCityList = new ArrayList<>();
        fromCityList.add(dao.getCityById(2));
        fromCityList.add(dao.getCityById(3));
        fromCityList.add(dao.getCityById(4));
        toCityList.add(dao.getCityById(5));
        toCityList.add(dao.getCityById(6));
        toCityList.add(dao.getCityById(7));
        for (City fromCity : fromCityList) {
            for (City toCity : toCityList) {
                if (!fromCity.equals(toCity)) {
                    dao.saveDistance(Calculator.calculate(fromCity, toCity));
                }
            }
        }
        List<CityRestDto> fromCitiesRes = fromCityList.stream().map(c -> new CityRestDto(c)).collect(Collectors.toList());
        List<CityRestDto> toCitiesRest = toCityList.stream().map(c -> new CityRestDto(c)).collect(Collectors.toList());
        DistanceRequest distanceRequest = new DistanceRequest();
        distanceRequest.setCalculationType(CalculationType.DISTANCE_MATRIX.toString());
        distanceRequest.setFromCities(fromCitiesRes);
        distanceRequest.setToCities(toCitiesRest);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(distanceRequest);
        System.out.println("-------------------------");
        System.out.println(jsonString);
        System.out.println("-------------------------");
    }
}
