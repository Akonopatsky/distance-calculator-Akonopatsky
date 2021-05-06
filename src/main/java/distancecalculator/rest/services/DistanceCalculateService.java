package distancecalculator.rest.services;

import distancecalculator.rest.dto.CityDto;
import distancecalculator.rest.dto.DistanceDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DistanceCalculateService {
    List<CityDto> getAllCities();

    List<DistanceDto> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities);

    void upload(MultipartFile multipartFile);
}
