package models;

import db.DBBasket;
import db.DBCustomer;
import org.hibernate.dialect.ProgressDialect;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Entity
@Table(name = "customers")

public class Customer {

    private int id;
    private String customerName;
    private String customerAddress;
//    private Map<String, String> environmetnInfo;
    private List<Basket> baskets;
    private Shop shop;


    public Customer() {
    }

    public Customer(String customerName, String customerAddress, Shop shop) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
//        this.environmetnInfo = new HashMap<String, String>();
        this.baskets = new ArrayList<Basket>();
        this.shop = shop;
    }

//GETTERS & SETTERS


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "customer_address")
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


    @OneToMany(mappedBy = "customer")
    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }



    //OTHER METHODS
    public void addBasket(Basket basket){
        this.baskets.add(basket);
    }

    public void removeBasket(Basket basket){
        this.baskets.remove(basket);
    }

    public double emissionOfCustomersBaskets(){
        double footprintOfCustomer = 0;
        for (Basket basket : baskets){
            footprintOfCustomer += basket.emissionsOfProductsInBasket();
        }
        return footprintOfCustomer;
    }

    public Basket giveMeLastBasket(){
        int numberAllBaskets = this.getBaskets().size();
        return this.getBaskets().get(numberAllBaskets-1);
    }


    public HashMap< Integer, List<Product>> giveMeBasketsWithProducts (){
        HashMap <Integer, List<Product>> tempHash  = new HashMap<>();
        List<Basket> customersBaskets = DBCustomer.allBaskets(this);
        for (Basket basket : customersBaskets) {
            List<Product> tempArray = new ArrayList<>();
            List<Product> productsFromBasket = DBBasket.findAllProductsOfThis(basket);
            for (Product product : productsFromBasket){
                tempArray.add(product);
            }
            tempHash.put(basket.getId(), tempArray);
        }
        return tempHash;
    }

}
