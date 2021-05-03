package distancecalculator.services;

import distancecalculator.dto.CityIdName;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DistanceCalculateService {
    List<CityIdName> getAllCities();

    List<Double> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities);

    void updateDB(MultipartFile multipartFile);
}
