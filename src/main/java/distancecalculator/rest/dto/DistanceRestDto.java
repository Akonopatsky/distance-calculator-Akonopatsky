package distancecalculator.rest.dto;

import distancecalculator.model.Distance;

public class DistanceRestDto {
    private final String calculationType;
    private final CityRestDto fromCity;
    private final CityRestDto toCity;
    private final double distance;

    public DistanceRestDto(CalculationType calculationType, Distance distance) {
        this.calculationType = calculationType.toString();
        this.fromCity = new CityRestDto(distance.getFromCity());
        this.toCity = new CityRestDto(distance.getToCity());
        this.distance = distance.getDistance();
    }

    public String getCalculationType() {
        return calculationType;
    }

    public CityRestDto getFromCity() {
        return fromCity;
    }

    public CityRestDto getToCity() {
        return toCity;
    }

    public double getDistance() {
        return distance;
    }
}
