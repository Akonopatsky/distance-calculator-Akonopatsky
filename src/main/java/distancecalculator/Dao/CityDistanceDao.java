package distancecalculator.Dao;

import distancecalculator.model.City;
import distancecalculator.model.Distance;

import java.util.List;

public interface CityDistanceDao {
    List<City> getAllCities();

    List<Distance> getDistances(List<City> cityList);

    long saveDistanceList(List<Distance> distanceList);

    long saveCityList(List<City> cityList);
}
