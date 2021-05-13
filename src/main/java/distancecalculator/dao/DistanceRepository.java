package distancecalculator.dao;

import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.data.repository.CrudRepository;

public interface DistanceRepository extends CrudRepository<Distance, Long> {
    Distance findByFromCityAndToCity(City from, City to);
}
