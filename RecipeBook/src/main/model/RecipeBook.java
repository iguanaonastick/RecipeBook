package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeBook implements Writable {
//    private String recipeBookUser;
    private ArrayList<Recipe> newRecipeBook;

    // EFFECTS: initializes newRecipeBook as an empty list
    public RecipeBook() {
        newRecipeBook = new ArrayList<>();
//        recipeBookUser = user;
    }

    // MODIFIES: this
    // EFFECTS: adds recipe to newRecipeBook
    public void addRecipe(Recipe r) {
        newRecipeBook.add(r);
        EventLog.getInstance().logEvent(new Event("Added recipe " + r.getRecipeName()
                + " to the recipe book."));
    }

    // EFFECTS: returns an unmodifiable list of recipes in this recipeBook
    public List<Recipe> getRecipes() {
        return Collections.unmodifiableList(newRecipeBook);
    }

    // MODIFIES: this
    // EFFECTS: removes recipe from newRecipeBook
    public void removeRecipe(Recipe r) {
        newRecipeBook.remove(r);
        EventLog.getInstance().logEvent(new Event("Removed recipe " + r.getRecipeName()
                + " from the recipe book."));
    }

    // EFFECTS: returns number of recipes currently in newRecipeBook
    public int length() {
        return newRecipeBook.size();
    }

    // EFFECTS: return recipe with given string
    public Recipe returnRecipe(String r) {
        for (Recipe x : newRecipeBook) {
            if (r.equals(x.getRecipeName())) {
                return x;
            }

        }
        return null;
    }

    // EFFECTS: return list of recipe names
    public String printRecipeNames() {
        List<String> stringOfType = new ArrayList<>();
        for (Recipe r: newRecipeBook) {
            String recipeString = r.getRecipeName();
            stringOfType.add(recipeString);
        }
        if (stringOfType.isEmpty()) {
            return null;
        } else {
            return String.join(", ", stringOfType);
        }
    }

    // REQUIRES: Recipe exists in given FoodType
    // EFFECTS: given a specified FoodType, returns a list of food that are of the FoodType
    public String listOfFoodString(FoodType t) {
        List<String> stringOfType = new ArrayList<>();
        for (Recipe r : newRecipeBook) {
            List<FoodType> types = r.getType();
            for (FoodType type : types) {
                if (t == type) {
                    String recipeString = r.getRecipeName();
                    stringOfType.add(recipeString);
                }
            }
        }
        if (stringOfType.isEmpty()) {
            return null;
        } else {
            return String.join(", ", stringOfType);
        }
    }

    // EFFECTS: returns instructions for given recipe
    public String returnRecipeInstruction(String recipeName) {
        for (Recipe r : newRecipeBook) {
            if (recipeName.equals(r.getRecipeName())) {
                return r.getInstruction();
            }
        }
        return "The recipe does not exist";
    }

    // EFFECTS: returns all details of given recipe
    public String getAllDetailsRecipe(String recipeName) {
        for (Recipe r : newRecipeBook) {
            if (recipeName.equals(r.getRecipeName())) {
                return r.getAllDetails();
            }
        }
        return "The recipe does not exist";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("recipes", recipesToJson());
        return json;
    }

    // EFFECTS: returns recipes in this recipeBook as a JSON array
    private JSONArray recipesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Recipe r : newRecipeBook) {
            jsonArray.put(r.toJson());
        }

        return jsonArray;
    }


}
