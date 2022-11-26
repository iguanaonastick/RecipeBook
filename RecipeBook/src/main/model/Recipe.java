package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

import static model.FoodType.*;

public class Recipe implements Writable {
    private String recipeName;
    private List<FoodType> type;
    private List<String> ingredients;
    private String instruction;
    private int difficulty;
    private boolean hasMade;

    public Recipe(String recipeName, List<FoodType> type, List<String> ingredients, String instruction,
                  int difficulty, boolean hasMade) {
        this.recipeName = recipeName;
        this.type = type;
        this.ingredients = ingredients;
        this.instruction = instruction;
        this.difficulty = difficulty;
        this.hasMade = hasMade;
    }

    // SETTERS
    public void setRecipeName(String x) {
        recipeName = x;
    }

    // REQUIRES: input limited to-- Soup, Breakfast, Lunch, Dinner, Pastry, Fried Rice
    // EFFECTS: adds type of food to Recipe if not already there
    @SuppressWarnings("methodlength")
    public void setType(ArrayList<String> x) {
        for (String r: x) {
            if (r.equals("soup")) {
                if (!type.contains(SOUP)) {
                    type.add(SOUP);
                }
            }
            if (r.equals("breakfast")) {
                if (!type.contains(BREAKFAST)) {
                    type.add(BREAKFAST);
                }
            }
            if (r.equals("lunch")) {
                if (!type.contains(LUNCH)) {
                    type.add(LUNCH);
                }
            }
            if (r.equals("dinner")) {
                if (!type.contains(DINNER)) {
                    type.add(DINNER);
                }
            }
            if (r.equals("pastry")) {
                if (!type.contains(PASTRY)) {
                    type.add(PASTRY);
                }
            } else  {
                if (!type.contains(FRIEDRICE)) {
                    type.add(FRIEDRICE);
                }
            }
        }
    }

    public void setIngredients(List<String> x) {
        for (String r: x) {
            if (!ingredients.contains(r)) {
                ingredients.add(r);
            }
        }
    }

    public void setInstruction(String x) {
        instruction = x;
    }

    // REQUIRES: input only between int 1-5.
    public void setDifficulty(int x) {
        difficulty = x;
    }

    public void beenMade() {
        hasMade = true;
    }

    // GETTERS
    public String getRecipeName() {
        return recipeName;
    }

    public List<FoodType> getType() {
        return type;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean getHasMade() {
        return hasMade;
    }

    public String getAllDetails() {
        return "Recipe Name: " + recipeName + "\n" + "Type/s of Food: " + type + "\n" + "Ingredients: " + ingredients
                + "\n" + "Recipe: " + instruction + "\n" + "Difficulty Level: " + difficulty + "\n" + "Made before? "
                + hasMade;
    }

    // EFFECTS: changes Recipe object to JsonObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Recipe Name", recipeName);
        json.put("type", enumToString(type));
        json.put("ingredients", String.join(", ", ingredients));
        json.put("instruction", instruction);
        json.put("difficulty", difficulty);
        json.put("already made?", hasMade);
        return json;
    }

    // EFFECTS: converts list of FoodType to single string
    public String enumToString(List<FoodType> t) {
        List<String> shitList = new ArrayList<>();
        for (FoodType x : t) {
            shitList.add(x.name());
        }
        return String.join(", ", shitList);
    }

}
