package db;

import models.*;


public class Seeds {

    public static void seedData(){
        Shop shop = new Shop("new shop");
        DBHelper.save(shop);

        Farm farm_1 = new Farm("Animal Farms", "John McDonnald", "EH7", FuelConversionFactorType.ELECTRIC);
        Farm farm_2 = new Farm("HillView", "Ricardo Ruiz", "EH1", FuelConversionFactorType.DIESEL);
        Farm farm_3 = new Farm("BenAvis", "Dr Pawel Orzechowski", "EH2", FuelConversionFactorType.HYBRID);
        String bio1 = "Doggo ipsum borkf woofer many pats dat tungg tho, wow very biscit. Smol borking doggo with a long sno, many pater shibe many pats clouds shibe";
        String bio2 = "Doggo ipsum borkf woofer many pats dat tungg tho, wow very biscit. Smol borking doggo with a long sno, many pater shibe many pats clouds shibe";
        String bio3 = "Doggo ipsum borkf woofer many pats dat tungg tho, wow very biscit. Smol borking doggo with a long sno, many pater shibe many pats clouds shibe";
        farm_1.setBio(bio1);
        farm_2.setBio(bio2);
        farm_3.setBio(bio3);
        DBHelper.save(farm_1);
        DBHelper.save(farm_2);
        DBHelper.save(farm_3);


        Customer customer_1 = new Customer ("Patrycja Graczyk", "EH15", shop);
        Customer customer_2 = new Customer ("Melinda Matthews", "EH12", shop);
        Customer customer_3 = new Customer ("Colin Riddell", "EH9", shop);
        DBHelper.save(customer_1);
        DBHelper.save(customer_2);
        DBHelper.save(customer_3);

        Basket basket_1 = new Basket(customer_1);
        Basket basket_2 = new Basket(customer_2);
        Basket basket_3 = new Basket(customer_3);
        DBHelper.save(basket_1);
        DBHelper.save(basket_2);
        DBHelper.save(basket_3);

        Product product_1 = new Product("Mary Rose potatoes", GroupType.TUBERS, TagType.ORGANIC,1, farm_1, shop, 2.40);
        Product product_2 = new Product("Jones potatoes ", GroupType.TUBERS, TagType.ORGANIC,1.5, farm_2, shop, 2.00);
        Product product_3 = new Product("Strawberries", GroupType.FRUITS, TagType.VEGAN,.3, farm_2, shop, 3.00);
        Product product_4 = new Product("Chicken", GroupType.MEAT, TagType.ORGANIC,.5, farm_3, shop, 3.50);
        Product product_5 = new Product("Royal Cabbage", GroupType.VEGETEABLES, TagType.FAIRTRADE,0.4, farm_1, shop, 1.40);
        Product product_6 = new Product("Parsnip", GroupType.VEGETEABLES, TagType.ORGANIC,0.5, farm_2, shop, 1.00);
        Product product_7 = new Product("Honey", GroupType.MISC, TagType.VEGAN,0.5, farm_2, shop, 5.60);
        Product product_8 = new Product("Chickpeas", GroupType.PULSES, TagType.VEGAN,0.2, farm_3, shop, 0.50);
        Product product_9 = new Product("Sausages", GroupType.PROCESSED, TagType.ORGANIC,0.5, farm_2, shop, 8.00);
        Product product_10 = new Product("Rosemary", GroupType.HERBS, TagType.VEGAN,0.1, farm_2, shop, 3.00);
        Product product_11 = new Product("Sunflower Seeds", GroupType.GRAINS, TagType.VEGAN,0.1, farm_3, shop, 0.90);
        Product product_12 = new Product("Cheddar", GroupType.DAIRY, TagType.GLUTENFREE,0.3, farm_1, shop, 2.45);
        Product product_13 = new Product("Onions", GroupType.VEGETEABLES, TagType.ORGANIC,0.39, farm_2, shop, 3.11);
        Product product_14 = new Product("Carrots", GroupType.VEGETEABLES, TagType.VEGAN,0.2, farm_2, shop, 4.00);
        Product product_15 = new Product("Broccoli", GroupType.VEGETEABLES, TagType.VEGAN,0.2, farm_3, shop, 2.99);
        Product product_16 = new Product("Haggis", GroupType.PROCESSED, TagType.ORGANIC,0.5, farm_1, shop, 5.43);
        Product product_17 = new Product("Angus Beef Mince", GroupType.MEAT, TagType.FAIRTRADE,0.6, farm_2, shop, 6.00);
        Product product_18 = new Product("Blueberries", GroupType.FRUITS, TagType.VEGETARIAN,.5, farm_2, shop, 4.00);
        DBHelper.save(product_1);
        DBHelper.save(product_2);
        DBHelper.save(product_3);
        DBHelper.save(product_4);
        DBHelper.save(product_5);
        DBHelper.save(product_6);
        DBHelper.save(product_7);
        DBHelper.save(product_8);
        DBHelper.save(product_9);
        DBHelper.save(product_10);
        DBHelper.save(product_11);
        DBHelper.save(product_12);
        DBHelper.save(product_13);
        DBHelper.save(product_14);
        DBHelper.save(product_15);
        DBHelper.save(product_16);
        DBHelper.save(product_17);
        DBHelper.save(product_18);
    }
}
