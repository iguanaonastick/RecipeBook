package persistence;

import model.FoodType;
import model.Recipe;
import model.RecipeBook;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads RecipeBook from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads RecipeBook from file and returns it;
    // throws IOException if an error occurs reading data from file
    public RecipeBook read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseRecipeBook(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses RecipeBook from JSON object and returns it
    private RecipeBook parseRecipeBook(JSONObject jsonObject) {
        RecipeBook rb = new RecipeBook();
        addJsonRecipes(rb, jsonObject);
        return rb;
    }

    // MODIFIES: rb
    // EFFECTS: parses recipes from JSON object and adds them to RecipeBook
    private void addJsonRecipes(RecipeBook rb, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("recipes");
        for (Object jsonRecipe : jsonArray) {
            JSONObject nextRecipe = (JSONObject) jsonRecipe;
            addRecipe(rb, nextRecipe);
        }
    }

    // MODIFIES: rb
    // EFFECTS: parses recipe from JSON object and adds it to RecipeBook
    private void addRecipe(RecipeBook rb, JSONObject jsonObject) {
        String recipeName = jsonObject.getString("Recipe Name");
        List<String> listOfString = Arrays.asList(jsonObject.getString("type").split(", "));
        List<FoodType> listOfFoodType = new ArrayList<>();
        for (String x : listOfString) {
            FoodType anEnum = FoodType.valueOf(x);
            listOfFoodType.add(anEnum);
        }
        List<FoodType> type = listOfFoodType;
        List<String> ingredients = Arrays.asList(jsonObject.getString("ingredients").split(", "));
        String instruction = jsonObject.getString("instruction");
        int difficulty = jsonObject.getInt("difficulty");
        boolean hasMade = jsonObject.getBoolean("already made?");
        Recipe recipe = new Recipe(recipeName, type, ingredients, instruction, difficulty, hasMade);
        rb.addRecipe(recipe);
    }

/*    // EFFECTS: converts single string to List<FoodType>
    public List<FoodType> stringToEnum(String s) {
        List<String> listOfString = Arrays.asList(s.split(", "));
        List<FoodType> listOfFoodType = new ArrayList<>();
        for (String x : listOfString) {
            FoodType anEnum = FoodType.valueOf(x);
            listOfFoodType.add(anEnum);
        }
        return listOfFoodType;
    }*/
}
