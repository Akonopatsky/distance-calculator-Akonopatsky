package distancecalculator.rest.services;

import distancecalculator.dao.CityDistanceDao;
import distancecalculator.converters.XmlService;
import distancecalculator.dao.CityRepository;
import distancecalculator.dao.DistanceRepository;
import distancecalculator.dto.CitiesAndDistancesXML;
import distancecalculator.dto.CityDtoRest;
import distancecalculator.dto.DistanceDtoRest;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class DistanceCalculateServiceImpl implements DistanceCalculateService {
    private static final Logger logger = LoggerFactory.getLogger(DistanceCalculateServiceImpl.class);
    private CityDistanceDao dao;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistanceRepository distanceRepository;

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
        try {
            InputStream inputStream = multipartFile.getInputStream();
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            CitiesAndDistancesXML citiesAndDistancesXML = XmlService.unMarshalFile(inputStream);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
