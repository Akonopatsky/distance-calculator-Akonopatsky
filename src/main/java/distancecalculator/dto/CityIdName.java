package distancecalculator.dto;

import distancecalculator.model.City;

public class CityIdName {
    private final long id;
    private final String name;

    public CityIdName(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityIdName(City city) {
        this(city.getId(), city.getName());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
