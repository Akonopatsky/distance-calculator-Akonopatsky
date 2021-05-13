package distancecalculator.dao;

import distancecalculator.model.City;
import distancecalculator.model.Distance;

import java.util.List;

public interface CityDistanceDao {
    List<City> getAllCities();

    Distance getDistance(City fromCity, City toCity);

    List<Distance> saveDistanceList(List<Distance> distanceList);

    List<City> saveCityList(List<City> cityList);

    City saveCity(City city);

    Distance saveDistance(Distance distance);
}
