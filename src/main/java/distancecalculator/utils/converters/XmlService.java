package distancecalculator.utils.converters;


import distancecalculator.rest.dto.XmlDto;
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

    public static XmlDto unMarshal(InputStream inputStream) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlDto.class);
        return (XmlDto) jaxbContext.createUnmarshaller().unmarshal(inputStream);
    }

    public static void marshalInFile(XmlDto xmlDto, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(xmlDto, file);
    }
}
