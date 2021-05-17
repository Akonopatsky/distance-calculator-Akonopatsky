package distancecalculator.rest.dto;

import java.util.List;

public class DistanceRequest {

    private String calculationType;
    private List<CityRestDto> fromCities;
    private List<CityRestDto> toCities;

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public List<CityRestDto> getFromCities() {
        return fromCities;
    }

    public void setFromCities(List<CityRestDto> fromCities) {
        this.fromCities = fromCities;
    }

    public List<CityRestDto> getToCities() {
        return toCities;
    }

    public void setToCities(List<CityRestDto> toCities) {
        this.toCities = toCities;
    }

    public DistanceRequest() {
    }
}
