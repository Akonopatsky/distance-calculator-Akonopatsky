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

    public static<T> T unMarshal(InputStream inputStream, Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        return (T) jaxbContext.createUnmarshaller().unmarshal(inputStream);
    }

    public static<T> void marshal(T xmlDto, OutputStream outputStream, Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.marshal(xmlDto, outputStream);
    }

    public static<T> void marshalInFile(T xmlDto, File file, Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.marshal(xmlDto, file);
    }
}
