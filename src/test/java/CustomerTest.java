import models.*;
import org.junit.Before;
import org.junit.Test;

import static models.GroupType.FRUITS;
import static models.GroupType.TUBERS;
import static models.TagType.ORGANIC;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
        private Customer customer_1;
        private Basket basket1;
        private Product product_1;
        private Product product_2;
    private Farm farm1;


    @Before
    public void before(){
        Shop shop = new Shop("new shop");
        farm1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        product_1 = new Product("potatoes", TUBERS, ORGANIC,0.5, farm1, shop, 2.3 );
        product_2 = new Product("strawberries", FRUITS, ORGANIC,1.5, farm1, shop, 3.7);

        customer_1 = new Customer("Ricardo", "Edinburgh", shop);
        basket1 = new Basket(customer_1);
    }
    @Test
    public void hasName(){
        assertEquals("Ricardo", customer_1.getCustomerName());
    }

    @Test
    public void canSetName(){
        customer_1.setCustomerName("Stu");
        assertEquals("Stu", customer_1.getCustomerName());
    }

    @Test
    public void gotAddress(){
        assertEquals("Edinburgh", customer_1.getCustomerAddress());
    }

    @Test
    public void canSetAddress(){
        customer_1.setCustomerAddress("Glasgow");
        assertEquals("Glasgow", customer_1.getCustomerAddress());
    }

//    @Test
//    public void getFootprintOfCustomer(){
//        customer_1.addBasket(basket1);
//        basket1.addToBasket(product_1);
//        assertEquals(0.0022835, customer_1.emissionOfCustomersBasket(basket1),0);
//    }
//
//    @Test
//    public void getFootprintOfCustomerManyProducts(){
//        basket1.addToBasket(product_1);
//        basket1.addToBasket(product_2);
//        customer_1.addBasket(basket1);
//        assertEquals(0.009134, customer_1.emissionOfCustomersBasket(basket1),0);
//    }

//    @Test
//    public void canSetEnvInfo(){
//        customer_1.addEnvironmentalInfo("co2", "test");
//        assertEquals("test", customer_1.getEnvironmetnInfo().get("co2"));
//    }
//
//    @Test
//    public void canAddToBasket(){
//        Farms farm1 = new Farms("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
//        Product product1 = new Product("potatoes", GroupType.DAIRY, TagType.ORGANIC,1, farm1);
//        customer_1.addToBasket(product1);
//        assertEquals("potatoes", customer_1.getBasket().get(0).getProductName());
//    }
//



}
