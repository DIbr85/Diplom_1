import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestIngredient {
    IngredientType type;
    String name;
    float price;
    Ingredient ingredient;

    public TestIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "Бешамель", 25f},
                {IngredientType.FILLING, "Сосиска", 50f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetIngredientPrice() {
        Assert.assertEquals(ingredient.price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetIngredientName() {
        Assert.assertEquals(ingredient.name, ingredient.getName());

    }

    @Test
    public void testGetIngredientType() {
        Assert.assertEquals(ingredient.type, ingredient.getType());
    }
}
