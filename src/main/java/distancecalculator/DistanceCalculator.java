package distancecalculator;

import distancecalculator.dao.CityDistanceDao;
import distancecalculator.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistanceCalculator {
	private static final Logger logger = LoggerFactory.getLogger(DistanceCalculator.class);
private static CityDistanceDao cityDistanceDao;
	public static void main(String[] args) {
		SpringApplication.run(DistanceCalculator.class, args);
	}

}
