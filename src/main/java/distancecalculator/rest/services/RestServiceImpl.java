package distancecalculator.rest.services;

import distancecalculator.dao.CityDistanceDao;
import distancecalculator.exceptions.DistanceCalculatorException;
import distancecalculator.model.City;
import distancecalculator.model.Distance;
import distancecalculator.rest.dto.*;
import distancecalculator.utils.converters.XmlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RestServiceImpl implements RestService {
    private static final Logger logger = LoggerFactory.getLogger(RestServiceImpl.class);
    private final CityDistanceDao dao;
    private final DistanceService distanceService;
    private final UploadService uploadService;

    public RestServiceImpl(
            CityDistanceDao dao,
            DistanceService distanceService,
            UploadService uploadService
    ) {
        this.dao = dao;
        this.distanceService = distanceService;
        this.uploadService = uploadService;
    }

    @Override
    public List<CityRestDto> getAllCities() {
        List<City> cityList = dao.getAllCities();
        return cityList.stream()
                .map(c -> new CityRestDto(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DistanceRestDto> calculateDistance(
            CalculationType calculationType,
            List<CityRestDto> fromCities,
            List<CityRestDto> toCities
    ) throws DistanceCalculatorException {
        return distanceService.getDistanceList(calculationType, fromCities, toCities);
    }

    @Override
    public void upload(MultipartFile multipartFile) throws Exception {
        logger.info("try to parse file : {}", multipartFile.getName());
        InputStream inputStream = multipartFile.getInputStream();
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        XmlDto xmlDto = XmlService.unMarshal(inputStream, XmlDto.class);
        uploadService.uploadData(xmlDto);
    }

    @Override
    @Transactional(readOnly = true)
    public void writeCitiesToStream(final OutputStream outputStream) {
        Stream<City> cityStream = dao.findAllCitiesStream();
        CityRestDtoList cityRestDtoList = new CityRestDtoList();
        cityStream.forEach(cityRestDtoList::add);
        try {
            XmlService.marshal(cityRestDtoList, outputStream, CityRestDtoList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        };
    }
}
