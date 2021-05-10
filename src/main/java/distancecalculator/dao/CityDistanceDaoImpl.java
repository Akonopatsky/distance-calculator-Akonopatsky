package distancecalculator.dao;

import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityDistanceDaoImpl implements CityDistanceDao {
    @Override
    public List<City> getAllCities() {
        return null;
    }

    @Override
    public Distance getDistance(City fromCity, City toCity) {
        return null;
    }

    @Override
    public long saveDistanceList(List<Distance> distanceList) {
        return 0;
    }

    @Override
    public long saveCityList(List<City> cityList) {
        return 0;
    }
}
