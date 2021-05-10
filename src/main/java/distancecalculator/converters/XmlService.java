package distancecalculator.converters;


import distancecalculator.dto.CitiesAndDistancesXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

@Service
public class XmlService {
    private static final Logger logger = LoggerFactory.getLogger(XmlService.class);

    public static CitiesAndDistancesXML unMarshalFile(InputStream inputStream) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CitiesAndDistancesXML.class);
        return (CitiesAndDistancesXML) jaxbContext.createUnmarshaller().unmarshal(inputStream);
    }

    public static void marshal(CitiesAndDistancesXML citiesAndDistancesXML, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CitiesAndDistancesXML.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(citiesAndDistancesXML, file);
    }
}
