package Controllers;

import db.DBBasket;
import db.DBCustomer;
import db.DBHelper;
import db.DBProduct;
import models.Basket;
import models.Customer;
import models.Product;
import models.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class CustomersController {

    public CustomersController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

// EDIT get request
        get("/customers/:id/edit", (req, res) -> {
            Customer customer = DBHelper.find(Integer.parseInt(req.params(":id")), Customer.class);

            Map<String, Object> model = new HashMap<>();
            List<Shop> shops =DBHelper.getAll(Shop.class);
            model.put("shops", shops);
            model.put("customer", customer);

            model.put("template", "templates/customers/edit.vtl");
            return new ModelAndView(model,"templates/layout.vtl" );
        }, new VelocityTemplateEngine());

//  INDEX all customers
        get("/customers", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("template", "templates/customers/index.vtl");
            model.put("customers", customers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

// CREATE new customer - get request
        get("/customers/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Shop> shops =DBHelper.getAll(Shop.class);
            model.put("shops", shops);
            model.put("template", "templates/customers/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

// CREATE new customer - post
        post("/customers", (req, res) -> {
            int shopId = Integer.parseInt(req.queryParams(("shop")));
            Shop shop = DBHelper.find(shopId, Shop.class);
            String customerName = req.queryParams("customerName");
            String customerAddress = req.queryParams("customerAddress");
            Customer customer = new Customer(customerName, customerAddress, shop);
            DBHelper.save(customer);
            res.redirect("/customers");
            return null;
        }, new VelocityTemplateEngine());

//SHOW customer of ID
        get("/customers/:id", (req, res) -> {
            Customer customer = DBHelper.find(Integer.parseInt(req.params(":id")), Customer.class);
            Map<String, Object> model = new HashMap<>();
            List<Basket> basketList = DBCustomer.allBaskets(customer);

            HashMap<Integer, List<Product>> productsInBaskets = customer.giveMeBasketsWithProducts();
            ArrayList<List> allProductsYouhaveBought = new ArrayList<List>(productsInBaskets.values());
            List<List> historyOfPurchases = new ArrayList<>();

            model.put("allProductsYouhaveBought", allProductsYouhaveBought);
            model.put("historyOfPurchases", historyOfPurchases);
            model.put("basketList", basketList);
            model.put("customer", customer);
            model.put("template", "templates/customers/show.vtl");
            return new ModelAndView(model,"templates/layout.vtl" );
        }, new VelocityTemplateEngine());

// EDIT post request
        post("/customers/:id", (req, res) -> {
            Customer customer = DBHelper.find(Integer.parseInt(req.params(":id")), Customer.class);
            int shopId = Integer.parseInt(req.queryParams(("shop")));
            Shop shop = DBHelper.find(shopId, Shop.class);
            String customerName = req.queryParams("customerName");
            String customerAddress = req.queryParams("customerAddress");

            customer.setCustomerName(customerName);
            customer.setCustomerAddress(customerAddress);
            customer.setShop(shop);
            DBHelper.update(customer);
            res.redirect("/customers");
            return null;
        }, new VelocityTemplateEngine());

//  DELETE
        post("/customers/:id/delete", (req, res) -> {
            Customer customer = DBHelper.find(Integer.parseInt(req.params(":id")), Customer.class);
            DBHelper.delete(customer);
            res.redirect("/customers");
            return null;
        }, new VelocityTemplateEngine());
    }
}
