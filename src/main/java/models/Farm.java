package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@Entity
@Table(name = "farms")

public class Farm {

    private int id;
    private String farmName;
    private String farmerName;
    private String bio;
    private String address;
    private FuelConversionFactorType fuelConversionFactorType;
    private List<Product> products;

    public Farm(String farmName, String farmerName, String address, FuelConversionFactorType fuelConversionFactorType) {
        this.farmName = farmName;
        this.farmerName = farmerName;
        this.address = address;
        this.fuelConversionFactorType = fuelConversionFactorType;
    }

    public Farm() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "farm_name")
    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    @Column(name = "framer_name")
    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    @Column(name = "bio")
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Enumerated(value = EnumType.STRING)
    public FuelConversionFactorType getFuelConversionFactorType() {
        return fuelConversionFactorType;
    }

    public void setFuelConversionFactorType(FuelConversionFactorType fuelConversionFactorType) {
        this.fuelConversionFactorType = fuelConversionFactorType;
    }

    @OneToMany(mappedBy = "farm")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
