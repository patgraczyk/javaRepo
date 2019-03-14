package models;

public enum TagType {
    ORGANIC("Organic"),
    VEGETARIAN("Vegetarian"),
    GLUTENFREE("Gluten free"),
    FAIRTRADE("Fairtrade"),
    DAIRYFREE("Dairy free"),
    VEGAN("Vegan");

    private String description;

    TagType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
