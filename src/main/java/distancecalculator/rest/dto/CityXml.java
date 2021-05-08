package distancecalculator.rest.dto;

import distancecalculator.model.City;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "city")
@XmlType(propOrder = {"name", "latitude", "longitude"})
public class CityXml {
    private static final long serialVersionUID = 1L;

    private String name;
    private double latitude;
    private double longitude;

    public CityXml() {
    }

    public CityXml(City city) {
        setName(city.getName());
        setLatitude(city.getLatitude());
        setLongitude(city.getLongitude());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
