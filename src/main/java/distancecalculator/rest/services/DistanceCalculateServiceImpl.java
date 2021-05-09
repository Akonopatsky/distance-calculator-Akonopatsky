package distancecalculator.rest.services;

import distancecalculator.Dao.CityDistanceDao;
import distancecalculator.rest.dto.CityDtoRest;
import distancecalculator.rest.dto.DistanceDtoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DistanceCalculateServiceImpl implements DistanceCalculateService {
    private static final Logger logger = LoggerFactory.getLogger(DistanceCalculateServiceImpl.class);
    private final CityDistanceDao dao;

    public DistanceCalculateServiceImpl(CityDistanceDao dao) {
        this.dao = dao;
    }

    @Override
    public List<CityDtoRest> getAllCities() {
        return null;
    }

    @Override
    public List<DistanceDtoRest> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities) {
        return null;
    }

    @Override
    public void upload(MultipartFile multipartFile) {
        logger.info("try to parse file : {}", multipartFile.getName());


    }
}
