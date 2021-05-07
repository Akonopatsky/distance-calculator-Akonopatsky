package distancecalculator.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "city")
@XmlType(propOrder = {"id", "name", "latitude", "longitude"})
/*@XmlAccessorType(XmlAccessType.FIELD)*/
public class City {
    private long id;
    private String name;
    private double latitude;
    private double longitude;

    public City() {

    }

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @XmlElement(name = "longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
