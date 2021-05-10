package distancecalculator.rest.services;


import distancecalculator.Dao.Services.CsvFileLoader;
import distancecalculator.rest.dto.CitiesAndDistancesXML;
import distancecalculator.rest.dto.CityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.List;

@Service
public class XmlFileJaxbService {
    private static final Logger logger = LoggerFactory.getLogger(XmlFileJaxbService.class);

    public static CitiesAndDistancesXML unMarshalFile(InputStream inputStream) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CitiesAndDistancesXML.class);
/*        InputStream inputStream = multipartFile.getInputStream();*/
/*        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);*/
        return (CitiesAndDistancesXML) jaxbContext.createUnmarshaller().unmarshal(inputStream);
    }

    public static void marshal(CitiesAndDistancesXML citiesAndDistancesXML, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CitiesAndDistancesXML.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(citiesAndDistancesXML, file);
    }

    public static void main(String[] args) throws JAXBException, IOException {
        CitiesAndDistancesXML citiesAndDistancesXML = new CitiesAndDistancesXML();
        List<CityDto> cityDtoList = CsvFileLoader.readFromCSV("cities500.csv", ';');
        citiesAndDistancesXML.setCityList(cityDtoList);
        File file = new File("./test.xml");
        marshal(citiesAndDistancesXML, file);
        FileInputStream inputStream = new FileInputStream(file);
        CitiesAndDistancesXML citiesAndDistancesXML1 = (CitiesAndDistancesXML) unMarshalFile(inputStream);
        citiesAndDistancesXML1.getCityList().stream().limit(30).forEach(city ->
                logger.info("city {} latitude {} longitude {}", city.getName(), city.getLatitude(), city.getLongitude())
        );
    }
}
