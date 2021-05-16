package distancecalculator.dao;

import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DistanceRepository extends CrudRepository<Distance, Long> {

    Optional<Distance> findByFromCityAndToCity(City from, City to);
}
