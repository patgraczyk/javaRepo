import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static models.GroupType.TUBERS;
import static models.TagType.ORGANIC;

public class ShopTest {
    private Farm farm1;
    private Product product_1;
    private Customer customer_1;
    private Basket basket_1;
    private Shop shop;


    @Before
    public void before() {
        farm1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        ArrayList<Enum> tags = new ArrayList<Enum>();
        tags.add(ORGANIC);

        shop = new Shop("New shop");
        customer_1 = new Customer("Ricardo", "Edinburgh", shop);
        basket_1 = new Basket(customer_1);
        product_1 = new Product("potatoes", TUBERS, ORGANIC, 0.5, farm1, shop, 2.0);
//        product_1.setBasket(basket_1);
    }

    @Test
    public void hasName() {
        assertEquals("New shop", shop.getShopName());
    }

    @Test
    public void hasProducts(){
        shop.addProducts(product_1);
        assertEquals(1, shop.getShopProducts().size());
    }

    @Test
    public void hasCustomers(){
        shop.addCustomers(customer_1);
        assertEquals("Ricardo", shop.getCustomers().get(0).getCustomerName());
    }
}