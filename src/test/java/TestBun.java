import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import praktikum.Bun;


public class TestBun {
    String name = "Burger";
    float price = 123F;
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }


    @Test
    public void testGetNameBun() {
        Assert.assertEquals(name, bun.getName());

    }

    @Test
    public void testGetPriceBun() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }


}
