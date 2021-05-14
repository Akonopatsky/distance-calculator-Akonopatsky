package distancecalculator.dto;

public class DistanceRestDto {

    private final String fromCity;
    private final String toCity;
    private final double distance;

    public DistanceRestDto(String fromCity, String toCity, double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public double getDistance() {
        return distance;
    }
}
