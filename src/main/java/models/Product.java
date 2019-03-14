package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {

    private int id;
    private String productName;
    private GroupType groupType;
    private TagType tag;
    private double weight;
    private Farm farm;
    private Shop shop;
    private Basket basket;
    private double price;

    public Product(){}

    public Product(String productName, GroupType groupType, TagType tag, double weight, Farm farm, Shop shop, double price) {
        this.productName = productName;
        this.groupType = groupType;
        this.tag = tag;
        this.weight = weight;
        this.farm = farm;
        this.shop = shop;
        this.basket = null; // PRODUCTS START WITH NULL BASKET
        this.price = price;
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

    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Enumerated(value = EnumType.STRING)
    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    @Enumerated(value = EnumType.STRING)
    public TagType getTag() {
        return tag;
    }

    public void setTag(TagType tag) {
        this.tag = tag;
    }

    @Column(name = "weight")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "farm_id", nullable = false)
    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id", nullable = true)
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //OTHER METHODS


//    RETURNS EMISSIONS OF ONE PRODUCT BASED ON QUANTITY 1 -- WE NEED TO UPDATE THE QUANTITY


    public double emissionsOfProduct(){
        return (getGroupType().getFoodConversionFactor() * 1 * getWeight())/1000;
    }

    public double emissionsOfProductKG(Product product){
        return (product.getGroupType().getFoodConversionFactor() * 1 * product.getWeight())/1000;
    }

    public double emissionsOfFoodMilesTravelledNotUsed(int distance){
        return (getFarm().getFuelConversionFactorType().getFuelConversionFactor() * distance)/1000;
    }

    public double emissionsOfFoodMilesTravelled(){
        return (getFarm().getFuelConversionFactorType().getFuelConversionFactor()*1)/1000;
    }

    public double totalEmissions(){
        return emissionsOfProduct() + emissionsOfFoodMilesTravelled()/1000;
    }

    public double emissionsOfConventionalProduct(){
        return (getGroupType().getTravelDistance() * FuelConversionFactorType.PETROL.getFuelConversionFactor())/1000;
    }

//    TODO : Emissions from aviation

    public double differenceOfEmissions(){
        return emissionsOfConventionalProduct() - emissionsOfFoodMilesTravelled();
    }


    public double productEmissionsPlastic(){
        return (ConversionFactorPlastic.PET1.getConversionFactor() * 1 * this.getWeight())/1000;
    }




//    public double distance betweenaddresses(){
//    totalMilageBasket = 0() {
//
//        }
//
//    }
//
//Double totalMilageBasket = 0.00;
//    totalMilageBasket += Distance.distanceBetween(customer_1.getCustomerAddress(), orderedProduct.getFarm().getAddress());
//                farmsFromOrder.put(orderedProduct.getFarm().getId(), orderedProduct.getFarm());


//    public double emissionsOfFoodMilesTravelled(String point1, String point2){
//        int distanceTravelled = Distance.distanceBetween(point1, point2);
//        return (getFarm().getFuelConversionFactorType().getFuelConversionFactor() * distanceTravelled)/1000;
//    }


//    public double getEmissionsOfWaste(){
//        return 0.00;
//    }


}
