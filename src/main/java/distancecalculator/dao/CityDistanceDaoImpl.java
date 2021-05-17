package distancecalculator.dao;

import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class CityDistanceDaoImpl implements CityDistanceDao {
    private final CityRepository cityRepository;
    private final DistanceRepository distanceRepository;

    public CityDistanceDaoImpl(CityRepository cityRepository, DistanceRepository distanceRepository) {
        this.cityRepository = cityRepository;
        this.distanceRepository = distanceRepository;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(long id) throws DistanceCalculatorException {
        return cityRepository.findById(id).orElseThrow(() -> new DistanceCalculatorException("there is no city id " + id));
    }

    @Override
    public Optional<Distance> getDistance(City fromCity, City toCity) {
        return distanceRepository.findByFromCityAndToCity(fromCity, toCity);
    }


    @Override
    public List<Distance> saveDistanceList(List<Distance> distanceList) {
        return (List<Distance>) distanceRepository.saveAll(distanceList);
    }

    @Override
    public List<City> saveCityList(List<City> cityList) {
        return (List<City>) cityRepository.saveAll(cityList);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public Distance saveDistance(Distance distance) {
        return distanceRepository.save(distance);
    }

    @Override
    public Stream<City> findAllCitiesStream() {
        return cityRepository.findAllByCustomQueryAndStream();
    }
}
