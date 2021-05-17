package distancecalculator.rest.dto;

public enum CalculationType {
    CROW_FLIGHT("CROWFLIGHT"),
    DISTANCE_MATRIX("DISTANCEMATRIX"),
    ALL("All");

    private final String name;

    CalculationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
