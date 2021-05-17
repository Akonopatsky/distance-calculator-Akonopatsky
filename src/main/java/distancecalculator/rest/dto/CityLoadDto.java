package distancecalculator.rest.dto;

import distancecalculator.model.City;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "city")
@XmlType(propOrder = {"name", "latitude", "longitude"})
public class CityLoadDto {
    private static final long serialVersionUID = 1L;
    private String name;
    private double latitude;
    private double longitude;

    public CityLoadDto() {
    }

    public CityLoadDto(City city) {
        setName(city.getName());
        setLatitude(city.getLatitude());
        setLongitude(city.getLongitude());
    }

    public CityLoadDto(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }


    @XmlElement
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    @XmlElement
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }


    public double getLatitude() {
        return latitude;
    }

    public City createCity() {
        return new City(name, latitude, longitude);
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
