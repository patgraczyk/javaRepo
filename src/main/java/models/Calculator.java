package models;

public class Calculator {

    public double emissionsOfProductCalc(Product product){
        return (product.getGroupType().getFoodConversionFactor() * 1 * product.getWeight())/1000;
    }

//

    public double emissionsOfProductKGCalc(Product product){
        return (product.getGroupType().getFoodConversionFactor() * 1 * product.getWeight());
    }

    public double emissionsOfFoodMilesTravelledCalc(Product product, int distance){
        return (product.getFarm().getFuelConversionFactorType().getFuelConversionFactor() * distance)/1000;
    }

//    public double totalEmissionsCalc(){
//        return emissionsOfProductCalc() + emissionsOfFoodMilesTravelledCalc();
//    }

//    public double totalEmissionsCombined(){
//        double totalCombinedEmissions = 0;
//        for (Product product : productsInBasket){
//            totalCombinedEmissions += product.totalEmissions();
//        }
//        return totalCombinedEmissions;
//    }
}


