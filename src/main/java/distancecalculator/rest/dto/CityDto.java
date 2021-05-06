package distancecalculator.rest.dto;

public class CityDto {
    private final long id;
    private final String name;

    public CityDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
