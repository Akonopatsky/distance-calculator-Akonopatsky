package distancecalculator.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "distances")
public class Distance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "fromCity_id")
    private City fromCity;

    @OneToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "toCity_id")
    private City toCity;
    private double distance;

    public Distance() {
    }

    public Distance(City fromCity, City toCity, double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

/*    public Distance(long id, City fromCity, City toCity, double distance) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }*/

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distance)) return false;
        Distance distance1 = (Distance) o;
        return Double.compare(distance1.distance, distance) == 0 && fromCity.equals(distance1.fromCity) && toCity.equals(distance1.toCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCity, toCity, distance);
    }

    @Override
    public String toString() {
        return "Distance{" +
                "id=" + id +
                ", fromCity=" + fromCity +
                ", toCity=" + toCity +
                ", distance=" + distance +
                '}';
    }
}
