package distancecalculator.Dao;

import distancecalculator.calculator.model.City;
import distancecalculator.calculator.model.Distance;

import java.util.List;

public interface CityDistanceDao {
    List<City> getAllCities();

    Distance getDistance(City fromCity, City toCity);

    long saveDistanceList(List<Distance> distanceList);

    long saveCityList(List<City> cityList);
}
