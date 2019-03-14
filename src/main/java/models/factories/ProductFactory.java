package models.factories;

import db.DBHelper;
import models.Farm;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductFactory {
        static public ArrayList<Product> makeProductsFromParams(Set<String> paramsFromWeb) {
            ArrayList<Product> products = new ArrayList<Product>();
            for (String entry: paramsFromWeb) {
                if (entry.contains("prod_")) {
                    String productId = entry.substring(5);
                    products.add(DBHelper.find(Integer.parseInt(productId), Product.class));
                }
            }
            return products;
        }
}
