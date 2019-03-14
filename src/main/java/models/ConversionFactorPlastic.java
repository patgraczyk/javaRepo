package models;

public enum ConversionFactorPlastic {

//    CONVERSION ASSUMPTION - AVERAGE FOR ALL PLASTICS

    HDPE ("HDPE", 3188),
    PET1 ("PET1", 1123),
    VEGWARE ("VEGWARE", 4.55);

    private String plasticType;
    private double conversionFactor;

    ConversionFactorPlastic(String plasticType, double conversionFactor) {
        this.plasticType = plasticType;
        this.conversionFactor = conversionFactor;
    }

    public String getPlasticType() {
        return plasticType;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }


}
