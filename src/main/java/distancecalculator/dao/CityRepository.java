package distancecalculator.dao;

import distancecalculator.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();

    City getById(long id);

    Optional<City> getCityById(long id);

    @Query("select u from City u")
    Stream<City> findAllByCustomQueryAndStream();
}
