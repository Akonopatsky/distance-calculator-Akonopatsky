package distancecalculator.rest.services;


import distancecalculator.model.City;
import distancecalculator.model.Distance;
import org.springframework.jdbc.support.xml.XmlBinaryStreamProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class XmlFileJaxbService {

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
        City city1 = new City("City1", 111.11, 119.119);
        City city2 = new City("City3", 222.22, 229.229);
        City city3 = new City("City3", 333.33, 339.339);
        City city4 = new City("City4", 444.44, 449.449);
        city1.setId(1L);
        city2.setId(2L);
        city3.setId(3L);
        city4.setId(4L);


        Distance distance1 = new Distance(city1, city2, 1188);
        Distance distance2 = new Distance(city3, city4, 2288);
        distance1.setId(1L);
        distance1.setId(2L);
        JAXBContext jaxbContext = JAXBContext.newInstance(City.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(city1, new File("./test.xml"));
        marshaller.marshal(city2, new File("./test.xml"));

    }
}
