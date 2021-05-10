package distancecalculator.rest.services;

import distancecalculator.rest.dto.CityDtoRest;
import distancecalculator.rest.dto.DistanceDtoRest;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface DistanceCalculateService {
    List<CityDtoRest> getAllCities();

    List<DistanceDtoRest> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities);

    void upload(MultipartFile multipartFile);
}
