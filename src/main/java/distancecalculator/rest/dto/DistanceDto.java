package distancecalculator.rest.dto;

public class DistanceDto {

    private final String fromCity;
    private final String toCity;
    private final double distance;

    public DistanceDto(String fromCity, String toCity, double distance) {
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
