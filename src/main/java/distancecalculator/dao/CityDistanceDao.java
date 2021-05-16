package distancecalculator.dao;

import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface CityDistanceDao {

    List<City> getAllCities();

    City getById(long id) throws DistanceCalculatorException;

    Optional<Distance> getDistance(City fromCity, City toCity);

    List<Distance> saveDistanceList(List<Distance> distanceList);

    List<City> saveCityList(List<City> cityList);

    City saveCity(City city);

    Distance saveDistance(Distance distance);

    @Transactional(readOnly = true)
    Stream<City> findAllCitiesStream();
}
