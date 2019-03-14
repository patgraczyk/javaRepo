import models.Farm;
import models.FuelConversionFactorType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FarmTest {

    private Farm farm1;

    @Before
    public void before(){
        farm1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
    }

    @Test
    public void farmHasName(){
        assertEquals("Animal Farms", farm1.getFarmName());
    }

    @Test
    public void hasFarmerName(){
        assertEquals("McDonnald", farm1.getFarmerName());
    }

    @Test
    public void hasAddress(){
        assertEquals("FarmRoad 7", farm1.getAddress());
    }

    @Test
    public void hasPetrolType(){
        assertEquals("electric", FuelConversionFactorType.ELECTRIC.getDescription());
    }

    @Test
    public void getConversionFactor(){
        assertEquals(2.45, FuelConversionFactorType.ELECTRIC.getFuelConversionFactor(),0);
    }

}
