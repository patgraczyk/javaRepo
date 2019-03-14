import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static models.GroupType.FRUITS;
import static models.GroupType.TUBERS;
import static models.TagType.ORGANIC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductTest {

    private Product product_1;
    private Farm farm1;
    private Farm farm2;

    @Before
    public void before() {
        farm1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);

        ArrayList<Enum> tags = new ArrayList<Enum>();
        tags.add(ORGANIC);
        Shop shop = new Shop("new shop");


        product_1 = new Product("potatoes", TUBERS, ORGANIC, 0.5, farm1, shop, 2.4);
    }

    @Test
    public void startEmptyID() {
        assertEquals(0, product_1.getId());
    }

    @Test
    public void gotName() {
        assertEquals("potatoes", product_1.getProductName());
    }

    @Test
    public void canSetName() {
        product_1.setProductName("strawberries");
        assertEquals("strawberries", product_1.getProductName());
    }

//    @Test
//    public void gotGroupEnum(){
//        assertEquals(TUBERS, product_1.getGroup());
//    }
//
//    @Test
//    public void setGroup(){
//        product_1.setGroup(FRUITS);
//        assertEquals(FRUITS, product_1.getGroup());
//    }
//
//    @Test
//    public void gotTags() {
//        assertEquals(ORGANIC, product_1.getTag());
//    }

//    @Test
//    public void canSetTag() {
////        set diff tag
//        assertEquals(0, product_1.getTag());
//    }

    @Test
    public void gotWeight() {
        assertEquals(0.5, product_1.getWeight(), 0);
    }

    @Test
    public void canSetWeight() {
        product_1.setWeight(.75);
        assertEquals(0.75, product_1.getWeight(), 0);
    }

    @Test
    public void gotFarm() {
        assertEquals("Animal Farms", product_1.getFarm().getFarmName());
    }

    @Test
    public void canSetFarm() {
        farm2 = new Farm("Hillview", "Smith", "FarmRoad 8", FuelConversionFactorType.DIESEL);
        product_1.setFarm(farm2);
        assertEquals("Hillview", product_1.getFarm().getFarmName());

    }
}
//
//    @Test
//    public void canGetEmissionsOfProduct(){
//        assertEquals(0.0022835, product_1.emissionsOfProduct(),0);
//    }
//
//    @Test
//    public void canGetEmissionsOfDistance(){
//        assertEquals(0.24500000000000002, product_1.emissionsOfFoodMilesTravelled(),0);
//    }
//
//    @Test
//    public void getTotalEmissions(){
//        assertEquals(0.24728350000000002, product_1.totalEmissions(),0);
//    }
//}
