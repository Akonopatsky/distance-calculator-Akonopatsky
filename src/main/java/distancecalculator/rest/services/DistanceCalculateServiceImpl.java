package distancecalculator.rest.services;

import distancecalculator.dao.CityDistanceDao;
import distancecalculator.model.City;
import distancecalculator.utils.converters.XmlService;
import distancecalculator.dto.CitiesAndDistancesXML;
import distancecalculator.dto.CityRestDto;
import distancecalculator.dto.DistanceRestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistanceCalculateServiceImpl implements DistanceCalculateService {
    private static final Logger logger = LoggerFactory.getLogger(DistanceCalculateServiceImpl.class);
    private CityDistanceDao dao;

    public DistanceCalculateServiceImpl(CityDistanceDao dao) {
        this.dao = dao;
    }

    @Override
    public List<CityRestDto> getAllCities() {
        List<City> cityList = dao.getAllCities();
        return cityList.stream()
                .map(c -> new CityRestDto(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DistanceRestDto> calculateDistance(String calculationType, List<String> fromCities, List<String> toCities) {
        return null;
    }

    @Override
    public void upload(MultipartFile multipartFile) {
        logger.info("try to parse file : {}", multipartFile.getName());
        try {
            InputStream inputStream = multipartFile.getInputStream();
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            CitiesAndDistancesXML citiesAndDistancesXML = XmlService.unMarshal(inputStream);
            //List<City> cityDtoList = citiesAndDistancesXML.getCityList();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
