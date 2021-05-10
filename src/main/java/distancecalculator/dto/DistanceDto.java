package distancecalculator.dto;

import distancecalculator.model.Distance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class DistanceDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fromCity;
    private String toCity;
    private double distance;

    public DistanceDto() {
    }

    public DistanceDto(Distance distance) {
        setFromCity(distance.getFromCity().getName());
        setToCity(distance.getToCity().getName());
        setDistance(distance.getDistance());
    }

    public String getFromCity() {
        return fromCity;
    }

    @XmlElement
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    @XmlElement
    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public double getDistance() {
        return distance;
    }

    @XmlElement
    public void setDistance(double distance) {
        this.distance = distance;
    }

}
