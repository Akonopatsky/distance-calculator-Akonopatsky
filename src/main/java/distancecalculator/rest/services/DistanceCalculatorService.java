package distancecalculator.rest.services;

import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.rest.dto.CalculationType;
import distancecalculator.rest.dto.CityRestDto;
import distancecalculator.rest.dto.DistanceRestDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface DistanceCalculatorService {
    List<CityRestDto> getAllCities();

    List<DistanceRestDto> calculateDistance(CalculationType calculationType, List<CityRestDto> fromCities, List<CityRestDto> toCities) throws DistanceCalculatorException;

    void upload(MultipartFile multipartFile) throws Exception;

    void writeCitiesToStream(OutputStream outputStream);

}
