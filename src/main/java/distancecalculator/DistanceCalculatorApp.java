package distancecalculator;

import distancecalculator.dao.CityDistanceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistanceCalculatorApp {
	private static final Logger logger = LoggerFactory.getLogger(DistanceCalculatorApp.class);
private static CityDistanceDao cityDistanceDao;
	public static void main(String[] args) {
		SpringApplication.run(DistanceCalculatorApp.class, args);
	}

}
