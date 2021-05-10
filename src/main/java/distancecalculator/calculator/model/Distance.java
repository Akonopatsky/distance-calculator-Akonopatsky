package distancecalculator.calculator.model;

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

    public Distance(long id, City fromCity, City toCity, double distance) {
        this.id = id;
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

}
