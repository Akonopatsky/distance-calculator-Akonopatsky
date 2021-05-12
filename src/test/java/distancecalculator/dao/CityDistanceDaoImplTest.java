package distancecalculator.dao;

import distancecalculator.DistanceCalculator;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CityDistanceDaoImplTest {
    private static final Logger logger = LoggerFactory.getLogger(CityDistanceDaoImplTest.class);
    @Autowired
    private CityDistanceDao dao;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    DistanceRepository distanceRepository;

    @Test
    void getAllCities() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void saveDistanceList() {
    }

    @Test
    void saveCityList() {
    }

    @Test
    void saveCity() {
        City city1 = new City("London", 12.25, 32.244);
        logger.info("city1 {} ", city1);
        City returnCity = dao.saveCity(city1);
        logger.info("city1 {} ", city1);
        logger.info("city2 ");
        City city2 = new City("NeyYork", 15.25, 32.244);
        logger.info("save city2 ");
        dao.saveCity(city2);
        logger.info("distance ");
        Distance distance1 = new Distance(city1, city2, 500);
        dao.saveDistance(distance1);
        List<City> cities = (List<City>) cityRepository.findAll();
        cities.forEach(c -> System.out.println(c));
        List<Distance> distances = (List<Distance>) distanceRepository.findAll();
        distances.forEach(System.out::println);

    }
}