package praktikum;

import org.junit.Assert;
import org.junit.Test;
public class IngredientTypeTest {

    @Test
    public void checkValueOfSauce() {
        Assert.assertNotNull(IngredientType.valueOf("SAUCE"));
    }
    @Test
    public void checkValueOfSFilling() {
        Assert.assertNotNull(IngredientType.valueOf("FILLING"));
    }
}