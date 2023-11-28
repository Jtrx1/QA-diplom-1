import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void checkSetBuns() {
        Object expected = bun;
        Burger burger=new Burger();
        burger.setBuns(bun);
        Object actual=burger.bun;
        assertEquals(expected, actual);
    }

    @Test
    public void checkAddIngredient() {
        List<Ingredient> expected = List.of(ingredient);
        Burger burger=new Burger();
        burger.addIngredient(ingredient);
        List<Ingredient> actual = burger.ingredients;
        assertEquals(expected, actual);
    }

    @Test
    public void checkRemoveIngredient() {
        int expected = 0;
        Burger burger=new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        assertEquals(expected, actual);
    }

    @Test
    public void checkMoveIngredient() {
        String expected="Две мясных котлеты гриль";
        Mockito.when(ingredient.getName()).thenReturn(expected);
        Burger burger=new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        String actual = burger.ingredients.get(1).getName();
        assertEquals(expected, actual);
    }

    @Test
    public void checkGetPrice() {
        float expected=25F;
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getPrice()).thenReturn(5F);
        Burger burger=new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual=burger.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("белая булка");
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(50F);
        Mockito.when(secondIngredient.getName()).thenReturn("Кетчуп");
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getPrice()).thenReturn(5F);

        String expected="(==== белая булка ====)" + System.lineSeparator()+
                "= sauce Кетчуп =" + System.lineSeparator()+
                "= filling Котлета =" + System.lineSeparator()+
                "= sauce Кетчуп =" + System.lineSeparator()+
                "(==== белая булка ====)" + System.lineSeparator()+
                System.lineSeparator()+
                "Price: 80,000000"+ System.lineSeparator();

        Burger burger=new Burger();
        burger.setBuns(bun);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        String actual=burger.getReceipt();
        System.out.println(burger.getReceipt());

        assertEquals(expected, actual);
    }

}
