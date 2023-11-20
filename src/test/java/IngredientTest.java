import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType ingredientType;
    private String ingredientName;
    private float price;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float price){
      this.ingredientName=ingredientName;
      this.ingredientType=ingredientType;
      this.price=price;
    }
    @Parameterized.Parameters
    public static Object[][] ingredientData() {
        return new Object[][]{
                {SAUCE, "сырный соус", 123F},
                {SAUCE, "соус барбекю", 99F},
                {FILLING, "котлета говяжья", 200F},
                {FILLING, "помидорка",70F},
                {FILLING, "огурчик", 50F},
                {FILLING, "котлета куриная", 150F},
        };

    }
    @Test
    public void checkGetPrice() {
        float expected=price;
        Ingredient ingredient=new Ingredient(ingredientType, ingredientName, price);
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void checkGetName() {
        String expected=ingredientName;
        Ingredient ingredient=new Ingredient(ingredientType, ingredientName, price);
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void checkGetType() {
        Object expected = ingredientType;
        Ingredient ingredient=new Ingredient(ingredientType, ingredientName, price);
        Object actual = ingredient.getType();
        assertEquals(expected,actual);
    }
}