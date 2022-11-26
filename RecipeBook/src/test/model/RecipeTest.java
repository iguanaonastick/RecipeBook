package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.FoodType.*;
import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private Recipe newRecipe1;
    private Recipe newRecipe2;
    private Recipe newRecipe3;
    private Recipe newRecipe4;
    private Recipe newRecipe5;
    private Recipe newRecipe6;
    private Recipe newRecipe7;
    private Recipe newRecipe8;
    private List<FoodType> testRecipeFoodType1;
    private List<FoodType> testRecipeFoodType2;
    private List<FoodType> testRecipeFoodType3;
    private List<FoodType> testRecipeFoodType4;
    private List<FoodType> testRecipeFoodType5;
    private List<FoodType> testRecipeFoodType6;
    private List<FoodType> testRecipeFoodType7;
    private List<FoodType> testRecipeFoodType8;
    private List<String> testRecipeIngredients1;
    private List<String> testRecipeIngredients2;
    private List<String> testRecipeIngredients3;
    private List<String> testRecipeIngredients4;
    private List<String> testRecipeIngredients5;
    private List<String> testRecipeIngredients6;
    private List<String> testRecipeIngredients7;
    private List<String> testRecipeIngredients8;



    @BeforeEach
    void runBefore() {

        testRecipeIngredients1 = new ArrayList<>(Arrays.asList("Garlic", "1 lb. Chicken", "Soy Sauce"));
        testRecipeFoodType1 = new ArrayList<>(Arrays.asList(DINNER, LUNCH));
        newRecipe1 = new Recipe ("Adobo",testRecipeFoodType1, testRecipeIngredients1,
                "Chop Garlic, etc.", 3, false);

        testRecipeIngredients2 = new ArrayList<>(Arrays.asList("Flour", "Yeast", "3 Eggs"));
        testRecipeFoodType2 = new ArrayList<>(Arrays.asList(PASTRY, BREAKFAST));
        newRecipe2 = new Recipe ("Croissant", testRecipeFoodType2, testRecipeIngredients2,
                "Get batter, mix it, etc.", 5, false);

        testRecipeIngredients3 = new ArrayList<>(Arrays.asList("1 Kg. Cheddar Cheese", "50 Eggs", "Flour"));
        testRecipeFoodType3 = new ArrayList<>(Arrays.asList(BREAKFAST));
        newRecipe3 = new Recipe ("Cheesecake", testRecipeFoodType3, testRecipeIngredients3,
                "Make batter, add cheese, etc.", 5, false);

        testRecipeIngredients4 = new ArrayList<>(Arrays.asList("1 lb. Beef", "8 Potatoes", "3 Onions"));
        testRecipeFoodType4 = new ArrayList<>(Arrays.asList(DINNER));
        newRecipe4 = new Recipe("Roast Beef", testRecipeFoodType4, testRecipeIngredients4,
                "Rub beef, chop onions, etc.", 3, false);

        testRecipeIngredients5 = new ArrayList<>(Arrays.asList("1 kg. White Rice", "30 Eggs", "Soy Sauce"));
        testRecipeFoodType5 = new ArrayList<>(Arrays.asList(BREAKFAST, LUNCH, DINNER, FRIEDRICE));
        newRecipe5 = new Recipe("Salted Fish Fried Rice", testRecipeFoodType5, testRecipeIngredients5,
                "Cook rice, cook eggs, stir fry all and add soy sauce", 2, false);

        testRecipeIngredients6 = new ArrayList<>(Arrays.asList("10 kg. Sugar, Rice, Egg"));
        testRecipeFoodType6 = new ArrayList<>(Arrays.asList(PASTRY, FRIEDRICE));
        newRecipe6 = new Recipe("Sweet Fried Rice", testRecipeFoodType6, testRecipeIngredients6,
                "Cook rice, cook eggs, stir fry all and add sugar", 1, false);

        testRecipeIngredients7 = new ArrayList<>(Arrays.asList("Noodles", "Rice", "Egg", "Shrimp", "Sugar", "Bread"));
        testRecipeFoodType7 = new ArrayList<>(Arrays.asList(BREAKFAST, LUNCH, SOUP));
        newRecipe7 = new Recipe("Lomi", testRecipeFoodType7, testRecipeIngredients7,
                "Add noodles, cook rice, mix egg, add shrimp, add sugar, add bread", 5, false);

        testRecipeIngredients8 = new ArrayList<>(Arrays.asList("Salt", "Pepper", "Egg", "Orange Juice", "Rice",
                "Water"));
        testRecipeFoodType8 = new ArrayList<>(Arrays.asList(LUNCH, BREAKFAST, SOUP));
        newRecipe8 = new Recipe("Leftover Mix", testRecipeFoodType8, testRecipeIngredients8,
                "Add rice, sprinkle salt and pepper, add egg, add orange juice, add rice, mix well",
                1, false);
    }
    @Test
    public void testSetType1() {
        ArrayList<String> setTypeTest = new ArrayList<>(Arrays.asList("soup", "dinner"));
        ArrayList<FoodType> initialExpected = new ArrayList<>(Arrays.asList(BREAKFAST, LUNCH, DINNER, FRIEDRICE));
        assertEquals(initialExpected, newRecipe5.getType());
        newRecipe5.setType(setTypeTest);

        ArrayList<FoodType> finalExpected = new ArrayList<>(Arrays.asList(BREAKFAST, LUNCH, DINNER, FRIEDRICE, SOUP));
        assertEquals(finalExpected, newRecipe5.getType());
    }

    @Test
    public void testSetType2() {
        ArrayList<String> setTypeTest = new ArrayList<>(Arrays.asList("pastry", "fried rice", "dinner", "breakfast",
                "lunch"));
        newRecipe6.setType(setTypeTest);

        ArrayList<FoodType> finalExpected = new ArrayList<>(Arrays.asList(PASTRY, FRIEDRICE, DINNER, BREAKFAST, LUNCH));
        assertEquals(finalExpected, newRecipe6.getType());
    }

    @Test
    public void testSetType3() {
        ArrayList<String> setTypeTest = new ArrayList<>(Arrays.asList("fried rice", "pastry"));
        newRecipe7.setType(setTypeTest);

        ArrayList<FoodType> finalExpected = new ArrayList<>(Arrays.asList(BREAKFAST, LUNCH, SOUP, FRIEDRICE, PASTRY));
        assertEquals(finalExpected, newRecipe7.getType());
    }

    @Test
    public void testSetType4() {
        ArrayList<String> setTypeTest = new ArrayList<>(Arrays.asList("lunch", "breakfast", "soup", "fried rice"));
        newRecipe8.setType(setTypeTest);

        ArrayList<FoodType> finalExpected = new ArrayList<>(Arrays.asList(LUNCH, BREAKFAST, SOUP, FRIEDRICE));
        assertEquals(finalExpected, newRecipe8.getType());
    }

    @Test
    public void testSetIngredients() {
        ArrayList<String> setTypeTest = new ArrayList<>(Arrays.asList("Flour", "Milk"));

        assertEquals((Arrays.asList("1 Kg. Cheddar Cheese", "50 Eggs", "Flour")), newRecipe3.getIngredients());
        newRecipe3.setIngredients(setTypeTest);

        assertEquals((Arrays.asList("1 Kg. Cheddar Cheese", "50 Eggs", "Flour", "Milk")), newRecipe3.getIngredients());
    }

    @Test
    public void testSetRecipeName() {
        assertEquals("Roast Beef", newRecipe4.getRecipeName());
        newRecipe4.setRecipeName("Scrumptious Roast Beouf");

        assertEquals("Scrumptious Roast Beouf", newRecipe4.getRecipeName());
    }

    @Test
    public void testSetInstruction() {
        assertEquals("Chop Garlic, etc.", newRecipe1.getInstruction());
        newRecipe1.setInstruction("Chop Garlic, fry garlic, add chicken, and stew.");

        assertEquals("Chop Garlic, fry garlic, add chicken, and stew.",
                newRecipe1.getInstruction());
    }

    @Test
    public void testSetDifficulty() {
        assertEquals(2, newRecipe5.getDifficulty());
        newRecipe5.setDifficulty(1);

        assertEquals(1, newRecipe5.getDifficulty());
    }

    @Test
    public void testBeenMade() {
        assertFalse(newRecipe2.getHasMade());
        newRecipe2.beenMade();

        assertTrue(newRecipe2.getHasMade());
    }

    @Test
    public void testEnumToString() {
        assertEquals("DINNER, LUNCH", newRecipe1.enumToString(testRecipeFoodType1));
    }

}
