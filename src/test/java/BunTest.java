import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;


    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }
    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][] {
                {"Зеленая булка", 100},
                {"Красная булка", 50},
                {"Обычная белая булка с чесноком и зеленым луком", 150}
        };
    }
    @Test
    public void checkGetName() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }
    @Test
    public void checkGetPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(),0);
    }
}