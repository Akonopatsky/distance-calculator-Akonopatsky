package distancecalculator.dao;

import distancecalculator.model.City;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CityDistanceDaoImplTest {
    private static final Logger logger = LoggerFactory.getLogger(CityDistanceDaoImplTest.class);
private CityDistanceDao cityDistanceDao;
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
        City city = new City("London", 12.25, 32.244);
        City returnCity = cityDistanceDao.saveCity(city);
        logger.info("id {} name {} longitude {} latitude {}",
                returnCity.getId(),
                returnCity.getName(),
                returnCity.getLatitude(),
                returnCity.getLongitude());

    }
}