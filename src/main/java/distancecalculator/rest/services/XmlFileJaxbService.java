package distancecalculator.rest.services;


import distancecalculator.model.City;
import distancecalculator.model.Distance;
import distancecalculator.rest.dto.CityDistanceListXml;
import distancecalculator.rest.dto.DistanceXml;
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
        City city1 = new City(1L,"City1", 111.11, 119.119);
        City city2 = new City(2L,"City3", 222.22, 229.229);
        City city3 = new City(3L,"City3", 333.33, 339.339);
        City city4 = new City(4L,"City4", 444.44, 449.449);

        Distance distance1 = new Distance(1L, city1, city2, 1188);
        Distance distance2 = new Distance(2L, city3, city4, 2288);

        CityDistanceListXml cityDistanceListXml = new CityDistanceListXml();
        cityDistanceListXml.addCity(city1);
        cityDistanceListXml.addCity(city2);
        cityDistanceListXml.addCity(city3);
        cityDistanceListXml.addCity(city4);
        cityDistanceListXml.addDistance(distance1);
        cityDistanceListXml.addDistance(distance2);

        JAXBContext jaxbContext = JAXBContext.newInstance(CityDistanceListXml.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(cityDistanceListXml, new File("./test.xml"));


    }
}
