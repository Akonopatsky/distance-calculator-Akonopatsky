package distancecalculator.Dao;

import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class CityDistanceDaoImpl implements CityDistanceDao {
    @Override
    public List<City> getAllCities() {
        return null;
    }

    @Override
    public List<Distance> getDistances(List<City> cityList) {
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
