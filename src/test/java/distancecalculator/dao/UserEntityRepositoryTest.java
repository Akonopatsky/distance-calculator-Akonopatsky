package distancecalculator.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserEntityRepositoryTest {

    @Autowired private EntityManager entityManager;
    @Autowired private CityRepository cityRepository;
    @Autowired private DistanceRepository distanceRepository;
    @Autowired private CityDistanceDao cityDistanceDao;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(entityManager).isNotNull();
        assertThat(cityRepository).isNotNull();
        assertThat(distanceRepository).isNotNull();
        assertThat(cityDistanceDao).isNotNull();
    }
}