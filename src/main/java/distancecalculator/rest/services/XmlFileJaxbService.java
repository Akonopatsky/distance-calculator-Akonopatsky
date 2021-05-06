package distancecalculator.rest.services;


import distancecalculator.model.Distance;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class XmlFileJaxbService {

    public List<Distance> unMarshalFile(MultipartFile multipartFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Distance.class);
        return (Distance) jaxbContext.createUnmarshaller()
                .unmarshal(multipartFile);
    }

}
