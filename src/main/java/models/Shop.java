package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "shops")

public class Shop {

    private int id;
    private String shopName;
    private List<Product> shopProducts;
    private List<Customer> customers;

    public Shop(String shopName) {

        this.shopName = shopName;
        this.shopProducts = new ArrayList<Product>();
        this.customers = new ArrayList<Customer>();
    }

    public Shop() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @OneToMany(mappedBy = "shop")
    public List<Product> getShopProducts() {
        return shopProducts;
    }

    public void setShopProducts(List<Product> shopProducts) {
        this.shopProducts = shopProducts;
    }

    @OneToMany(mappedBy = "shop")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomers(Customer customer){
        this.customers.add(customer);
    }

    public void addProducts(Product product){
        this.shopProducts.add(product);
    }

    public static ArrayList<Product> updateArrayToHaveOnlyUniqueProducts(List<Product> notUniqueArrayOfProducts){
        HashMap tempHashHelper = new HashMap();

        for (Product product : notUniqueArrayOfProducts)
        { if (product.getBasket() == null) {
            tempHashHelper.put(product.getProductName(), product ); }
        }
        return new ArrayList<>(tempHashHelper.values());
    }
}
