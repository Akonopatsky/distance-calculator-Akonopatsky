package distancecalculator.calculator.model;

public enum CalculationType {
    CROWFLIGHT("Crowflight"),
    DISTANCE_MATRIX("DistanceMatrix"),
    ALL("All");

    private final String name;

    CalculationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
