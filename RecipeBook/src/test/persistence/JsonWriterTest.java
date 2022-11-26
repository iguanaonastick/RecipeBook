package persistence;

import model.Recipe;
import model.RecipeBook;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static model.FoodType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            RecipeBook rb = new RecipeBook();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyRecipeBook() {
        try {
            RecipeBook rb = new RecipeBook();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyRecipeBook.json");
            writer.open();
            writer.write(rb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyRecipeBook.json");
            rb = reader.read();
            assertEquals(0, rb.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralRecipeBook() {
        try {
            RecipeBook rb = new RecipeBook();
            rb.addRecipe(new Recipe("Fooder", Arrays.asList(SOUP, BREAKFAST),
                    Arrays.asList("Beef", "Pepper"), "throw in beef then season", 2,
                    false));
            rb.addRecipe(new Recipe("Fooder1", Arrays.asList(LUNCH, PASTRY), Arrays.asList("Pork", "Salt"),
                    "Add pork then season", 2, true));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralRecipeBook.json");
            writer.open();
            writer.write(rb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralRecipeBook.json");
            rb = reader.read();
            List<Recipe> recipes = rb.getRecipes();
            assertEquals(2, recipes.size());
            checkRecipe("Fooder", Arrays.asList(SOUP, BREAKFAST),
                    Arrays.asList("Beef", "Pepper"), "throw in beef then season", 2,
                    false, recipes.get(0));
            checkRecipe("Fooder1", Arrays.asList(LUNCH, PASTRY), Arrays.asList("Pork", "Salt"),
                    "Add pork then season", 2, true, recipes.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
