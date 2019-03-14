package models;

import java.util.ArrayList;
import java.util.List;

public enum FuelConversionFactorType {

    PETROL ("Petrol", 0.45),
    DIESEL ("Diesel", 0.35),
    BIODIESEL ("Biodiesel", 0.45),
    HYBRID ("Hybrid", 0.26),
    BATTERYELECTRIC ("BatteryElectric", 0.00),
    ELECTRIC("Electric", 0.07);

    private String description;
    private double fuelConversionFactor;

    FuelConversionFactorType(String description, double fuelConversionFactor) {
        this.description = description;
        this.fuelConversionFactor = fuelConversionFactor;
    }

    public String getDescription() {
        return description;
    }

    public double getFuelConversionFactor() {
        return fuelConversionFactor;
    }

//    TODO: Marcin to fix
//    public static List<FuelConversionFactorType> getAllFuelTypes(){
//        List<FuelConversionFactorType> fuelConversionFactorTypes = new ArrayList<>();
//        fuelConversionFactorTypes.add(PETROL);
//        fuelConversionFactorTypes.add(DIESEL);
//        fuelConversionFactorTypes.add(BIODIESEL);
//        fuelConversionFactorTypes.add(HYBRID);
//        fuelConversionFactorTypes.add(ELECTRIC);
//        return fuelConversionFactorTypes;
//    }

}
