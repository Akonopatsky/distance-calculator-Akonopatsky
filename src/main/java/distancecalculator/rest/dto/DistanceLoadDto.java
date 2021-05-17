package distancecalculator.rest.dto;

import distancecalculator.model.Distance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class DistanceLoadDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private long fromCity;
    private long toCity;
    private long id;
    private double distance;

    public DistanceLoadDto() {
    }

    public DistanceLoadDto(Distance distance) {
        setId(distance.getId());
        setFromCity(distance.getFromCity().getId());
        setToCity(distance.getToCity().getId());
        setDistance(distance.getDistance());
    }

    @XmlElement
    public long getId() {
        return id;
    }

    @XmlElement
    public void setFromCity(long fromCity) {
        this.fromCity = fromCity;
    }

    @XmlElement
    public void setToCity(long toCity) {
        this.toCity = toCity;
    }

    @XmlElement
    public void setDistance(double distance) {
        this.distance = distance;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getFromCity() {
        return fromCity;
    }

    public long getToCity() {
        return toCity;
    }

    public double getDistance() {
        return distance;
    }
}
