package distancecalculator.services;

import distancecalculator.dto.CityIdName;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DistanceCalculateServiceImpl implements DistanceCalculateService {
    @Override
    public List<CityIdName> getAllCities() {
        return null;
    }

    @Override
    public List<Double> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities) {
        return null;
    }

    @Override
    public void updateDB(MultipartFile multipartFile) {

    }
}
