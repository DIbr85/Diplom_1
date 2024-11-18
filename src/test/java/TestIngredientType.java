import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class TestIngredientType {
    @Test
    public void testCheckSauceIngredientType() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
    }
    @Test
    public void testCheckFillingIngredientType() {
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}

