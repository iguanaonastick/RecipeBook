package persistence;


import model.FoodType;
import model.Recipe;
import model.RecipeBook;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.FoodType.*;
import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            RecipeBook rb = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyRecipeBook() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyRecipeBook.json");
        try {
            RecipeBook rb = reader.read();
            assertEquals(0, rb.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralRecipeBook() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralRecipeBook.json");
        try {
            RecipeBook rb = reader.read();
            List<Recipe> recipes = rb.getRecipes();
            assertEquals(2, recipes.size());
            checkRecipe("food", Arrays.asList(SOUP, BREAKFAST), Arrays.asList("water", "rice"),
                    "do this", 5, false, recipes.get(0));
            checkRecipe("food1", Arrays.asList(PASTRY, DINNER), Arrays.asList("chicken", "egg"),
                    "do that", 3, true, recipes.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
