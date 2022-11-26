package persistence;

import model.FoodType;
import model.Recipe;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkRecipe(String recipeName, List<FoodType> type, List<String> ingredients, String instruction,
                               int difficulty, boolean hasMade, Recipe recipe) {
        assertEquals(recipeName, recipe.getRecipeName());
        assertEquals(type, recipe.getType());
        assertEquals(ingredients, recipe.getIngredients());
        assertEquals(instruction, recipe.getInstruction());
        assertEquals(difficulty, recipe.getDifficulty());
        assertEquals(hasMade, recipe.getHasMade());
    }
}
