package distancecalculator.rest.services;


import distancecalculator.model.Distance;
import org.springframework.jdbc.support.xml.XmlBinaryStreamProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class XmlFileJaxbService {

    public List<Distance> unMarshalFile(MultipartFile multipartFile) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Distance.class);
        InputStream initialStream = multipartFile.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);
        return (List<Distance>) jaxbContext.createUnmarshaller().unmarshal(initialStream);

    }

}
