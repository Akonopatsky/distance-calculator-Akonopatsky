package distancecalculator.rest.services;

import distancecalculator.Dao.CityDistanceDao;
import distancecalculator.rest.dto.CityDto;
import distancecalculator.rest.dto.DistanceDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DistanceCalculateServiceImpl implements DistanceCalculateService {
    private final CityDistanceDao dao;

    public DistanceCalculateServiceImpl(CityDistanceDao dao) {
        this.dao = dao;
    }

    @Override
    public List<CityDto> getAllCities() {
        return null;
    }

    @Override
    public List<DistanceDto> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities) {
        return null;
    }

    @Override
    public void upload(MultipartFile multipartFile) {

    }
}
