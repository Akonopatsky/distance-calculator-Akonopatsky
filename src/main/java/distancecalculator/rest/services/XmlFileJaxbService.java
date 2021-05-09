package distancecalculator.rest.services;


import distancecalculator.Dao.Services.CsvFileLoader;
import distancecalculator.model.Distance;
import distancecalculator.rest.dto.CitiesAndDistancesXML;
import distancecalculator.rest.dto.CityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

@Service
public class XmlFileJaxbService {
    private static final Logger logger = LoggerFactory.getLogger(XmlFileJaxbService.class);

    public Distance unMarshalFile(MultipartFile multipartFile) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Distance.class);
        InputStream initialStream = multipartFile.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);
        return (Distance) jaxbContext.createUnmarshaller().unmarshal(initialStream);
    }

    public void marshal(Distance distance) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Distance.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(distance, new File("./test.xml"));
    }

    public static void main(String[] args) throws JAXBException {
/*        City city1 = new City(1L, "City1", 111.11, 119.119);
        City city2 = new City(2L, "City3", 222.22, 229.229);
        City city3 = new City(3L, "City3", 333.33, 339.339);
        City city4 = new City(4L, "City4", 444.44, 449.449);

        Distance distance1 = new Distance(1L, city1, city2, 1188);
        Distance distance2 = new Distance(2L, city3, city4, 2288);

        CitiesAndDistancesXML citiesAndDistancesXML = new CitiesAndDistancesXML();
        citiesAndDistancesXML.addCity(city1);
        citiesAndDistancesXML.addCity(city2);
        citiesAndDistancesXML.addCity(city3);
        citiesAndDistancesXML.addCity(city4);
        citiesAndDistancesXML.addDistance(distance1);
        citiesAndDistancesXML.addDistance(distance2);*/
        CitiesAndDistancesXML citiesAndDistancesXML = new CitiesAndDistancesXML();
        List<CityDto> cityDtoList = CsvFileLoader.readFromCSV("cities500.csv", ';');
        citiesAndDistancesXML.setCityList(cityDtoList);
        JAXBContext jaxbContext = JAXBContext.newInstance(CitiesAndDistancesXML.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = new File("./test.xml");
/*        URL url = .getClass().getResource("/parentDirectory");*/

        marshaller.marshal(citiesAndDistancesXML, file);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CitiesAndDistancesXML citiesAndDistancesXML1 = (CitiesAndDistancesXML) unmarshaller.unmarshal(file);
        citiesAndDistancesXML1.getCityList().stream().limit(10).forEach(city ->
                logger.info("city {} latitude {} longitude {}", city.getName(), city.getLatitude(), city.getLongitude())
        );
/*        citiesAndDistancesXML1.getDistanceXmlList().forEach(distance -> logger.info("between {} and {} distance {}",
                distance.getFromCity(), distance.getToCity(), distance.getDistance()));*/


    }
}
