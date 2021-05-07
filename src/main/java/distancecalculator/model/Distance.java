package distancecalculator.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "city")
@XmlType(propOrder = {"id", "fromCity", "toCity", "distance"})
//@XmlAccessorType(XmlAccessType.FIELD)
public class Distance {
    private long id;
    private City fromCity;
    private City toCity;
    private double distance;

    public Distance() {
    }

    public Distance(City fromCity, City toCity, double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public double getDistance() {
        return distance;
    }

    @XmlAnyAttribute
    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "fromCity")
    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    @XmlElement(name = "toCity")
    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    @XmlElement(name = "distance")
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
