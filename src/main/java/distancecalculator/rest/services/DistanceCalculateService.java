package distancecalculator.rest.services;

import distancecalculator.dto.CityRestDto;
import distancecalculator.dto.DistanceRestDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DistanceCalculateService {
    List<CityRestDto> getAllCities();

    List<DistanceRestDto> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities);

    void upload(MultipartFile multipartFile);
}
