package distancecalculator.calculator;

import distancecalculator.calculator.model.City;
import distancecalculator.calculator.model.Distance;

public interface CalculateService {
    Distance calculate(City fromCity, City toCity);
    Distance getDistanceMatrix(City fromCity, City toCity);
}
