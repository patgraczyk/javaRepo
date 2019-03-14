package models;

public enum GroupType {

    PULSES("Pulses/beans", 3.45, 4834),
    DAIRY("Dairy", 5.67, 60),
    FRUITS("Fruits/Berries", 4.56, 1406),
    GRAINS("Grains", 2.65, 4834),
    HERBS("Herbs", 1.45, 60),
    MEAT("Meats/Poultry", 4.57, 659),
    MISC("Miscellaneous", 2.6, 1406),
    NUTS("Nuts/seeds", 5.1, 659),
    OILS("Oils", 3.45, 1406),
    PROCESSED("Processed foods", 5.1, 45),
    ROOT("Root crops", 1, 45),
    SEAFOOD("Seafood", 1, 45),
    TUBERS("Tubers", 4.57, 14068),
    VEGETEABLES("Vegetables", 3.45, 14068);

    private String description;
    private double foodConversionFactor;
    private double travelDistance;

    GroupType(String description, double foodConversionFactor, double travelDistance) {
        this.description = description;
        this.foodConversionFactor = foodConversionFactor;
        this.travelDistance = travelDistance;
    }

    public String getDescription() {
        return description;
    }

    public double getFoodConversionFactor() {
        return foodConversionFactor;
    }

    public double getTravelDistance() {
        return travelDistance;
    }
}
