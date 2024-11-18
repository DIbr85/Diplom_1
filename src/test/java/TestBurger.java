import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.*;


@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    Bun bun;
    Burger burger = new Burger();
    @Mock
    Ingredient fillingIngredient;
    @Mock
    Ingredient sauceIngredient;

    @Before
    public void setUp() {
        Mockito.when(bun.getName()).thenReturn("Ксамаанский пшетч");
        Mockito.when(bun.getPrice()).thenReturn(450F);
        Mockito.when(fillingIngredient.getType()).thenReturn(FILLING);
        Mockito.when(fillingIngredient.getName()).thenReturn("Жумаанская пастила");
        Mockito.when(fillingIngredient.getPrice()).thenReturn(295F);
        Mockito.when(sauceIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(sauceIngredient.getName()).thenReturn("Нектар физайя");
        Mockito.when(sauceIngredient.getPrice()).thenReturn(105F);

        burger.setBuns(bun);
        burger.addIngredient(fillingIngredient);
        burger.addIngredient(sauceIngredient);
    }

    @Test
    public void testSetBuns() {
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Assert.assertEquals(burger.ingredients.size(), 2);
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(1);
        Assert.assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(0, 1);
        Assert.assertEquals(sauceIngredient, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        float actualPrice = burger.getPrice();
        float expectedPrice = bun.getPrice() * 2 + fillingIngredient.getPrice() + sauceIngredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);

    }

    @Test
    public void testGetReceipt() {
        StringBuilder expectedReceipt;
        expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "Ксамаанский пшетч"));
        expectedReceipt.append(String.format("= %s %s =%n", "filling", "Жумаанская пастила"));
        expectedReceipt.append(String.format("= %s %s =%n", "sauce", "Нектар физайя"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "Ксамаанский пшетч"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 1300f));

        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());

    }
}
