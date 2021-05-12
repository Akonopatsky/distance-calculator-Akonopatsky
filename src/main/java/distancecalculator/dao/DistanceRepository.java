package distancecalculator.dao;

import distancecalculator.model.Distance;
import org.springframework.data.repository.CrudRepository;

public interface DistanceRepository extends CrudRepository<Distance, Long> {
}
