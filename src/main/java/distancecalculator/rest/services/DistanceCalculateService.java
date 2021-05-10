package distancecalculator.rest.services;

import distancecalculator.dto.CityDtoRest;
import distancecalculator.dto.DistanceDtoRest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DistanceCalculateService {
    List<CityDtoRest> getAllCities();

    List<DistanceDtoRest> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities);

    void upload(MultipartFile multipartFile);
}
