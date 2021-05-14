package distancecalculator.dto;

public class CityRestDto {
    private final long id;
    private final String name;

    public CityRestDto(long id, String name) {
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
