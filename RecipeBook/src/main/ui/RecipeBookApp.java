package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.FoodType;
import model.Recipe;
import model.RecipeBook;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.Arrays;
import java.util.Scanner;

import static model.FoodType.*;


public class RecipeBookApp {
    protected static final String JSON_STORE = "./data/recipeBook.json";
    protected RecipeBook recipeBook;
    private Scanner input;
    protected JsonWriter jsonWriter;
    protected JsonReader jsonReader;
    private RecipeBookUI recipeBookUI;

    // EFFECTS: runs the teller application
    public RecipeBookApp(RecipeBookUI recipeBookUI) {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runRecipeBook(recipeBookUI);
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runRecipeBook(RecipeBookUI recipeBookUI) {
//        boolean keepGoing = true;
//        String command = null;

        init(recipeBookUI);
        recipeBookUI.startTitleScreen();
//
//        while (keepGoing) {
//            displayMenu();
//            command = input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//
//        System.out.println("\nGoodbye!");
    }

//    // MODIFIES: this
//    // EFFECTS: processes user command
//    private void processCommand(String command) {
//        if (command.equals("a")) {
//            makeRecipe();
//        } else if (command.equals("d")) {
//            deleteRecipe();
//        } else if (command.equals("p")) {
//            printRecipe();
//        } else if (command.equals("t")) {
//            recipesOfFoodType();
//        } else if (command.equals("i")) {
//            returnInstruction();
//        } else if (command.equals("z")) {
//            editDifficulty();
//        } else if (command.equals("y")) {
//            addType();
//        } else if (command.equals("h")) {
//            addIngredients();
//        } else if (command.equals("x")) {
//            giveDetails();
//        } else if (command.equals("s")) {
//            saveRecipeBook();
//        } else if (command.equals("l")) {
//            loadRecipeBook();
//        } else {
//            System.out.println("Selection invalid");
//        }
//    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init(RecipeBookUI recipeBookUI) {
        this.recipeBookUI = recipeBookUI;
        recipeBook = new RecipeBook();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add a recipe to my recipe book");
        System.out.println("\td -> Remove a recipe from my recipe book");
        System.out.println("\tp -> Print all recipes");
        System.out.println("\tt -> Get all recipes of a specific food type");
        System.out.println("\ti -> Get a recipe's instruction");
        System.out.println("\tz -> Edit a recipe's difficulty");
        System.out.println("\ty -> Add to a recipe's type/s");
        System.out.println("\th -> Add to a recipe's ingredients");
        System.out.println("\tx -> Get all details of recipe");
        System.out.println("\ts -> Save Recipe Book to file");
        System.out.println("\tl -> Load Recipe Book from file");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: makes a recipe
    private void makeRecipe() {
        System.out.println("Enter recipe name:");
        String recipeName = input.next();
        System.out.println("Enter recipe type/s from given list (separate with comma followed by a space):"
                + "\n -> Soup"
                + "\n -> Breakfast"
                + "\n -> Lunch"
                + "\n -> Dinner"
                + "\n -> Pastry"
                + "\n -> Fried Rice");
        ArrayList<String> type = new ArrayList<>(Arrays.asList(input.next().toLowerCase().split(", ")));
        ArrayList<FoodType> emptyType = new ArrayList<>();
        System.out.println("Enter recipe ingredients (separate with comma followed by a space):");
        List<String> ingredients = new ArrayList<>(Arrays.asList(input.next().split(", ")));
        System.out.println("Enter recipe instructions:");
        String instruction = input.next();
        int difficulty = changeDifficulty();
        Recipe newRecipe = new Recipe(recipeName, emptyType, ingredients, instruction, difficulty, false);
        newRecipe.setType(type);
        recipeBook.addRecipe(newRecipe);
        System.out.println("This recipe has been added to your Recipe Book.");
    }

    // EFFECTS: restricts value of difficulty to 1-5
    private int changeDifficulty() {
        System.out.println("Enter recipe difficulty (1-5):");
        int difficulty = Integer.parseInt(input.next());
        if (difficulty > 0 && difficulty < 6) {
            return difficulty;
        } else {
            System.out.println("Invalid value, try again");
            return changeDifficulty();
        }
    }

    // MODIFIES: this
    // EFFECTS: removes specified recipe
    private void deleteRecipe() {
        System.out.println("Enter recipe to be deleted");
        Recipe recipeRecipe = recipeBook.returnRecipe(input.next());
        if (recipeRecipe == null) {
            System.out.println("Recipe could not be deleted; recipe does not exist");
        }
        recipeBook.removeRecipe(recipeRecipe);
    }

    // EFFECTS: prints all recipes in recipeBook
    private void printRecipe() {
        System.out.println(recipeBook.printRecipeNames());
    }

    // EFFECTS: returns recipes of given food type
    private void recipesOfFoodType() {
        System.out.println("Enter food type from the following list:"
                + "\n -> Soup"
                + "\n -> Breakfast"
                + "\n -> Lunch"
                + "\n -> Dinner"
                + "\n -> Pastry"
                + "\n -> Fried Rice");
        FoodType foodType = stringToType(input.next().toLowerCase());
        if (recipeBook.listOfFoodString(foodType) == null) {
            System.out.println("No recipe of this food type exists");
        } else {
            System.out.println(recipeBook.listOfFoodString(foodType));
        }
    }

    // EFFECTS: returns instructions of given recipe name
    private void returnInstruction() {
        System.out.println("Enter recipe name:");
        System.out.println(recipeBook.returnRecipeInstruction(input.next()));
    }

    // MODIFIES: this
    // EFFECTS: edits difficulty of recipe
    private void editDifficulty() {
        System.out.println("Enter recipe name:");
        String recipeName = input.next();
        Recipe recipeRecipe = recipeBook.returnRecipe(recipeName);
        if (recipeBook.returnRecipe(recipeName) == null) {
            System.out.println("The recipe does not exist");
        } else {
            System.out.println("Enter recipe difficulty (1-5):");
            int difficulty = Integer.parseInt(input.next());
            if (difficulty > 0 && difficulty < 6) {
                recipeRecipe.setDifficulty(difficulty);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds type to recipe's foodType/s
    private void addType() {
        System.out.println("Enter recipe name:");
        String recipeName = input.next();
        if (recipeBook.returnRecipe(recipeName) == null) {
            System.out.println("The recipe does not exist");
        } else {
            System.out.println("Enter recipe type/s from given list (separate with comma followed by a space):"
                    + "\n -> Soup"
                    + "\n -> Breakfast"
                    + "\n -> Lunch"
                    + "\n -> Dinner"
                    + "\n -> Pastry"
                    + "\n -> Fried Rice");
            ArrayList<String> type = new ArrayList<>(Arrays.asList(input.next().toLowerCase().split(", ")));
            Recipe foundRecipe = recipeBook.returnRecipe(recipeName);
            foundRecipe.setType(type);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds ingredients to a recipe
    private void addIngredients() {
        System.out.println("Enter recipe name:");
        String recipeName = input.next();
        if (recipeBook.returnRecipe(recipeName) == null) {
            System.out.println("The recipe does not exist");
        } else {
            System.out.println("Enter ingredients (separate with comma followed by a space):");
            List<String> ingredients = Arrays.asList(input.next().split(", "));
            Recipe foundRecipe = recipeBook.returnRecipe(recipeName);
            foundRecipe.setIngredients(ingredients);
        }
    }

    // EFFECTS: gives all details of recipe
    private void giveDetails() {
        System.out.println("Enter recipe name:");
        String recipeName = input.next();
        if (recipeBook.returnRecipe(recipeName) == null) {
            System.out.println("The recipe does not exist");
        } else {
            Recipe foundRecipe = recipeBook.returnRecipe(recipeName);
            System.out.println(foundRecipe.getAllDetails());
        }
    }

    // REQUIRES: input limited to-- Soup, Breakfast, Lunch, Dinner, Pastry, Fried Rice
    // EFFECTS: converts string to enum FoodType
    protected FoodType stringToType(String x) {
        if (x.equals("soup")) {
            return SOUP;
        } else if (x.equals("breakfast")) {
            return BREAKFAST;
        } else if (x.equals("lunch")) {
            return LUNCH;
        } else if (x.equals("dinner")) {
            return DINNER;
        } else if (x.equals("pastry")) {
            return PASTRY;
        }
        return FRIEDRICE;
    }

    // EFFECTS: saves the RecipeBook to file
    private void saveRecipeBook() {
        try {
            jsonWriter.open();
            jsonWriter.write(recipeBook);
            jsonWriter.close();
            System.out.println("Saved recipe book to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads RecipeBook from file
    private void loadRecipeBook() {
        try {
            recipeBook = jsonReader.read();
            System.out.println("Loaded recipe book from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}


