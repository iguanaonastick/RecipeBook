package model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static model.FoodType.*;
import static org.junit.jupiter.api.Assertions.*;

public class RecipeBookTest {
    private RecipeBook newRecipeBook;
    private Recipe testRecipe1;
    private Recipe testRecipe2;
    private Recipe testRecipe3;
    private List<FoodType> testRecipeFoodType1;
    private List<FoodType> testRecipeFoodType2;
    private List<FoodType> testRecipeFoodType3;
    private List<String> testRecipeIngredients1;
    private List<String> testRecipeIngredients2;
    private List<String> testRecipeIngredients3;



    @BeforeEach
    void runBefore() {

        newRecipeBook = new RecipeBook();

        testRecipeIngredients1 = new ArrayList<>(Arrays.asList("Garlic", "1 lb. Chicken", "Soy Sauce"));
        testRecipeFoodType1 = new ArrayList<>(Arrays.asList(DINNER, LUNCH));
        testRecipe1 = new Recipe ("Adobo", testRecipeFoodType1, testRecipeIngredients1,
                "Chop Garlic, etc.", 3, false);

        testRecipeIngredients2 = new ArrayList<>(Arrays.asList("Flour", "Yeast", "3 Eggs"));
        testRecipeFoodType2 = new ArrayList<>(Arrays.asList(PASTRY, BREAKFAST));
        testRecipe2 = new Recipe ("Croissant", testRecipeFoodType2, testRecipeIngredients2,
                "Get batter, mix it, etc.", 5, false);

        testRecipeIngredients3 = new ArrayList<>(Arrays.asList("1 Kg. Cheddar Cheese", "50 Eggs", "Flour"));
        testRecipeFoodType3 = new ArrayList<>(Arrays.asList(BREAKFAST));
        testRecipe3 = new Recipe ("Cheesecake", testRecipeFoodType3, testRecipeIngredients3,
                "Make batter, add cheese, etc.", 5, false);

    }

    @Test
    public void testAddRecipe() {
        newRecipeBook.addRecipe(testRecipe1);

        assertEquals(1, newRecipeBook.length());
    }

    @Test
    public void testRemoveRecipe() {
        newRecipeBook.addRecipe(testRecipe1);
        assertEquals(1, newRecipeBook.length());

        newRecipeBook.addRecipe(testRecipe2);
        assertEquals(2, newRecipeBook.length());

        newRecipeBook.removeRecipe(testRecipe1);
        assertEquals(1, newRecipeBook.length());
    }

    @Test
    public void testReturnRecipeSuccess() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertEquals(testRecipe1, newRecipeBook.returnRecipe("Adobo"));
        assertEquals(testRecipe2, newRecipeBook.returnRecipe("Croissant"));
        assertEquals(testRecipe3, newRecipeBook.returnRecipe("Cheesecake"));
    }

    @Test
    public void testReturnRecipeNull() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertNull(newRecipeBook.returnRecipe("Adobling"));
        assertNull(newRecipeBook.returnRecipe("Kwasant"));
        assertNull(newRecipeBook.returnRecipe("Gizzcake"));
    }

    @Test
    public void testListOfFoodStringSuccess() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertEquals("Croissant, Cheesecake", newRecipeBook.listOfFoodString(BREAKFAST));
    }

    @Test
    public void testListOfFoodStringNull() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertNull(newRecipeBook.listOfFoodString(SOUP));
    }

    @Test
    public void testReturnRecipeInstructionExists() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertEquals("Get batter, mix it, etc.",
                newRecipeBook.returnRecipeInstruction("Croissant"));
    }

    @Test
    public void testReturnRecipeInstructionNone() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertEquals("The recipe does not exist", newRecipeBook.returnRecipeInstruction("Chicken"));
    }

    @Test
    public void testGetAllDetailsRecipeNone() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe3);

        assertEquals("The recipe does not exist", newRecipeBook.getAllDetailsRecipe("Croissant"));
    }

    @Test
    public void testGetAllDetailsRecipeExists() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertEquals("Recipe Name: Adobo" + "\n" +
                "Type/s of Food: [DINNER, LUNCH]" + "\n" +
                "Ingredients: [Garlic, 1 lb. Chicken, Soy Sauce]" + "\n" +
                "Recipe: Chop Garlic, etc." + "\n" +
                "Difficulty Level: 3" + "\n" +
                "Made before? false", newRecipeBook.getAllDetailsRecipe("Adobo"));
    }

    @Test
    public void testGetRecipes() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertEquals(3, newRecipeBook.length());
        assertEquals(Arrays.asList(testRecipe1, testRecipe2, testRecipe3), newRecipeBook.getRecipes());
    }

    @Test
    public void testPrintRecipeNamesFail() {
        assertNull(newRecipeBook.printRecipeNames());
    }

    @Test
    public void testPrintRecipeNamesSuccess() {
        newRecipeBook.addRecipe(testRecipe1);
        newRecipeBook.addRecipe(testRecipe2);
        newRecipeBook.addRecipe(testRecipe3);

        assertEquals("Adobo, Croissant, Cheesecake", newRecipeBook.printRecipeNames());
    }
}
