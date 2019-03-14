import db.*;
import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Shop shop = new Shop("new shop");
        DBHelper.save(shop);

        Farm farm_1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        Farm farm_2 = new Farm("HillView", "Kevlag", "Alloa 8", FuelConversionFactorType.DIESEL);
        Farm farm_3 = new Farm("BenAvis", "Smith", "BogAvenue", FuelConversionFactorType.HYBRID);
        String bio1 = "cool bio";
        String bio2 = "super cool bio";
        String bio3 = "It is full of stars";
        farm_1.setBio(bio1);
        farm_2.setBio(bio2);
        farm_3.setBio(bio3);
        DBHelper.save(farm_1);
        DBHelper.save(farm_2);
        DBHelper.save(farm_3);
        System.out.println("Saved farms in db...");


        Customer customer_1 = new Customer ("Pat", "Edinburgh", shop);
        Customer customer_2 = new Customer ("Mike", "Livingston", shop);
        Customer customer_3 = new Customer ("Stuu", "Glasgow", shop);
        DBHelper.save(customer_1);
        DBHelper.save(customer_2);
        DBHelper.save(customer_3);
        System.out.println("Saved customers in db...");


        Product product_1 = new Product("Mary Rose potatoes", GroupType.TUBERS, TagType.ORGANIC,1, farm_1, shop, 2.4);
        Product product_2 = new Product("Jones potatoes ", GroupType.TUBERS, TagType.ORGANIC,1.5, farm_2, shop, 2.0);
        Product product_3 = new Product("strawberries", GroupType.FRUITS, TagType.ORGANIC,.3, farm_2, shop, 3.0);
        Product product_4 = new Product("chicken", GroupType.MEAT, TagType.ORGANIC,.5, farm_3, shop, 3.50);
        DBHelper.save(product_1);
        DBHelper.save(product_2);
        DBHelper.save(product_3);
        DBHelper.save(product_4);
        System.out.println("Saved products in db...");



        Basket basket_1 = new Basket(customer_1);
        Basket basket_2 = new Basket(customer_2);
        Basket basket_3 = new Basket(customer_3);
        Basket basket_4 = new Basket(customer_3);
        DBHelper.save(basket_4);

        DBHelper.save(basket_1);
        basket_2.addToBasket(product_2);
        DBHelper.save(basket_2);
        DBHelper.save(basket_3);
        System.out.println("Saved baskets in db...");


        List<Product> productsInBasket = DBBasket.findAllProductsOfThis(basket_1);

        List<Basket> basketList = DBCustomer.allBaskets(customer_1);

        Basket basket = customer_1.giveMeLastBasket();
//
//        customer_1 = DBHelper.find(customer_1.getId(), Customer.class);
//        List<Product> products = DBHelper.getAll(Product.class);

//        customer_1.giveMeLastBasket().addToBasket(product_1);


//        List<Product> products = DBFarm.allProductsFrom(farm_2);
//
//        Product productTest = DBHelper.find(1, Product.class);

//        List<Product> productTest2 =  DBHelper.getAll(Product.class);
//
////        DBHelper.delete(product1);
//
//        List<Product> productList = DBShop.allProductsForShop();
//
//        List<Basket> baskets = DBHelper.getAll(Basket.class);
//
//        List<Customer> basketsTest = DBHelper.getAll(Customer.class);
//
//        List<Farm> farms = DBHelper.getAll(Farm.class);
//
//        List<Shop>  shops = DBHelper.getAll(Shop.class);
//
//        List<Basket> basketsOfCustomer = DBCustomer.allBaskets(customer_1);

//        List<int[]> distancesAll = Distance.setUpDistances();
//        int tesDistances1 =  Distance.distanceBetween("eh1","eh2");
//        int tesDistances2 =  Distance.distanceBetween("eh3","eh15");
//        int tesDistances3 =  Distance.distanceBetween("eh14","eh15");


    }
}
