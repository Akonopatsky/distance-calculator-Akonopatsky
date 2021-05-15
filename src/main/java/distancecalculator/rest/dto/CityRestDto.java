package distancecalculator.rest.dto;

import distancecalculator.model.City;

public class CityRestDto {
    private final long id;
    private final String name;

    public CityRestDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityRestDto(City city) {
        this.id = city.getId();
        this.name = city.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
