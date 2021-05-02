package services;

import dto.CalculationType;
import dto.CityIdName;

import java.util.List;

public interface DistanceCalculateService {
List<CityIdName> getAllCities();
List<Double> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities);
}
