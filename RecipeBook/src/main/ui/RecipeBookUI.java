package ui;

import model.FoodType;
import model.Recipe;
import model.Event;
import model.EventLog;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// represents the GUI
public class RecipeBookUI extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final Color BACKGROUND_COLOUR = new Color(113, 61, 197);
    private static final Color LIGHTER_BACKGROUND_COLOUR = new Color(153, 101, 237);
    private static final Color DARKER_BACKGROUND_COLOUR = new Color(93, 41, 177);
    private static final Color MATRIX_GREEN_TEXT_COLOUR = new Color(0x26D726);
    private static final Font MAIN_TITLE_FONT = new Font("Comic Sans MS", Font.BOLD, 30);
    private static final Font SUBTITLE_FONT = new Font("Comic Sans MS", Font.PLAIN, 15);

    private RecipeBookApp recipeBookApp;

    // MAIN TITLE PAGE FIELDS
    private JLabel mainTitle;
    private JButton mainTitleButtonNextPage;

    // OPTIONS PAGE FIELDS
    private JFrame optionsFrame;
    private JPanel optionsPane;

    // OPTIONS PAGE BUTTON FIELDS
    private JButton addRecipe;
    private JButton removeRecipe;
    private JButton printRecipe;
    private JButton getRecipeOfFoodType;
    private JButton getInstruction;
    private JButton editDifficulty;
    private JButton addType;
    private JButton addIngredients;
    private JButton getAllDetails;
    private JButton saveRecipeBook;
    private JButton loadRecipeBook;

    // ADDRECIPE FRAMES/PANELS/BUTTONS
    private JFrame frameAddRecipe;
    private JPanel panelAddRecipe;
    private JFrame frameInstruction;
    private JLabel labelInstruction;
    private JScrollPane scrollPaneInstruction;

    // ADDRECIPE BUTTON LISTS
    private ArrayList<JButton> listOfJButtonFoodType;
    private ArrayList<JButton> listOfJButtonInstruction;
    private ArrayList<JButton> listOfJButtonDifficulty;
    private ArrayList<JButton> listOfJButtonMadeBefore;
    private ArrayList<JButton> listOfJButtonFoodTypeRecipeSearch;
    private ArrayList<JButton> listOfJButtonAddFoodType;

    // ADDRECIPE JTEXTFIELDS FIELDS
    private JTextField recipeNameTextField;
    private JTextField ingredientsTextField;

    // ADDRECIPE JBUTTONFOODTYPE FIELDS
    private JButton soupButton;
    private JButton breakfastButton;
    private JButton lunchButton;
    private JButton dinnerButton;
    private JButton pastryButton;
    private JButton friedRiceButton;

    // ADDRECIPE JBUTTONINSTRUCTION FIELD
    private JButton instructionButton;

    // ADDRECIPE JBUTTONDIFFICULTY FIELDS
    private JButton difficulty1Button;
    private JButton difficulty2Button;
    private JButton difficulty3Button;
    private JButton difficulty4Button;
    private JButton difficulty5Button;

    // ADDRECIPE JBUTTONMADEBEFORE FIELDS
    private JButton yesButton;
    private JButton noButton;

    // ADDRECIPE GIVENVALUES FIELDS
    private int givenDifficulty;
    private ArrayList<String> givenFoodTypeInString;
    //    private String givenSoup;
//    private String givenBreakfast;
//    private String givenLunch;
//    private String givenDinner;
//    private String givenPastry;
//    private String givenFriedRice;
    private boolean givenHasMade;
    private JTextArea textAreaInstruction;

    // REMOVERECIPE FRAMES/PANELS/BUTTONS FIELDS
    private JFrame frameRemoveRecipe;
    private JTextField removeTextField;
    private JButton removeRecipeSubmitButton;
    private JPanel panelRemoveRecipe;

    // PRINTRECIPE FRAMES/PANELS/BUTTONS FIELDS
    private JFrame framePrintRecipe;
    private JPanel panelPrintRecipe;


    // FOODTYPERECIPE FRAMES/PANELS/BUTTONS FIELDS
    private JButton soupButton1;
    private JButton breakfastButton1;
    private JButton lunchButton1;
    private JButton dinnerButton1;
    private JButton pastryButton1;
    private JButton friedRiceButton1;
    private JFrame frameFoodTypeRecipe;
    private JPanel panelFoodTypeRecipe;
    private String currentFoodTypeRecipeSearch;
    private JFrame frameRecipesOfFoodTypeListed;
    private JPanel panelRecipesOfFoodTypeListed;

    // RETURNINSTRUCTION FRAMES/PANELS/BUTTONS/FIELDS
    private JFrame frameReturnInstruction;
    private JPanel panelReturnInstruction;
    private JTextField returnInstructionTextField;
    private String returnedRecipe;
    private JFrame frameFinalInstruction;
    private JPanel panelFinalInstruction;

    // EDITDIFFICULTY FRAMES/PANELS/BUTTONS/FIELDS
    private JFrame frameEditDifficulty;
    private JPanel panelEditDifficulty;
    private JTextField editDifficultyTextField;
    private Recipe difficultyRecipe;
    private JTextField finalEditDifficultyTextField;
    private JFrame frameFinalEditDifficulty;
    private JPanel panelFinalEditDifficulty;

    // ADDTYPE FRAMES/PANELS/BUTTONS/FIELDS
    private ArrayList<String> listOfFoodTypeAddType;
    private JFrame frameAddType;
    private JPanel panelAddType;
    private JButton soupButton2;
    private JButton breakfastButton2;
    private JButton lunchButton2;
    private JButton dinnerButton2;
    private JButton pastryButton2;
    private JButton friedRiceButton2;
    private JFrame frameFinalAddType;
    private JPanel panelFinalAddType;
    private JTextField addFoodTypePromptTextField;

    // ADDINGREDIENTS FRAMES/PANELS/BUTTONS/FIELDS
    private JFrame frameAddIngredients;
    private JPanel panelAddIngredients;
    private JTextField addIngredientsPromptTextField;
    private JFrame frameFinalAddIngredients;
    private JPanel panelFinalAddIngredients;
    private List<String> theIngredients;
    private JTextField finalAddIngredientsTextField;

    // GIVEDETAILS FRAMES/PANELS/BUTTONS/FIELDS
    private JFrame frameGiveDetails;
    private JPanel panelGiveDetails;
    private JTextField giveDetailsPromptField;
    private JFrame frameFinalGiveDetails;
    private JPanel panelFinalGiveDetails;


    // SUBMIT BUTTONS
    private JButton addRecipeSubmitButton;
    private JButton addInstructionSubmitButton;
    private JButton foodTypeRecipeSubmitButton;
    private JButton printRecipesDoneButton;
    private JButton recipesOfFoodTypeListedDoneButton;
    private JButton returnInstructionSubmitButton;
    private JButton finalInstructionDoneButton;
    private JButton editDifficultySubmitButton;
    private JButton finalEditDifficultySubmitButton;
    private JButton addTypeSubmitButton;
    private JButton finalAddTypeDoneButton;
    private JButton addIngredientsSubmitButton;
    private JButton finalAddIngredientsButton;
    private JButton giveDetailsSubmitButton;
    private JButton finalGiveDetailsSubmitButton;

    // initializes mostly everything
    @SuppressWarnings("methodlength")
    public RecipeBookUI() {
        super("Recipe Book 8=D");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(WIDTH, HEIGHT);
        getContentPane().setBackground(BACKGROUND_COLOUR);
        setVisible(true);

        // MAIN TITLE PAGE CONSTRUCTORS
        mainTitle = new JLabel();
        mainTitleButtonNextPage = new GoToOptionsPageButton();

        // OPTIONS PAGE CONSTRUCTORS
        optionsFrame = new JFrame();
        optionsFrame.setSize(WIDTH, HEIGHT);
        optionsPane = new JPanel();

        // OPTIONS PAGE BUTTON CONSTRUCTORS
        addRecipe = new OptionsPageButton("Add a recipe");
        removeRecipe = new OptionsPageButton("Remove a recipe");
        printRecipe = new OptionsPageButton("Print all recipe/s");
        getRecipeOfFoodType = new OptionsPageButton("Get all recipes of a specific food type");
        getInstruction = new OptionsPageButton("Get a recipe's instruction");
        editDifficulty = new OptionsPageButton("Edit a recipe's difficulty");
        addType = new OptionsPageButton("Add to a recipe's type/s");
        addIngredients = new OptionsPageButton("Add to a recipe's ingredients");
        getAllDetails = new OptionsPageButton("Get all details of recipe");
        saveRecipeBook = new OptionsPageButton("Save this recipe book");
        loadRecipeBook = new OptionsPageButton("Load recipe book");

        // ADDRECIPE CONSTRUCTORS
        frameAddRecipe = new JFrame();
        panelAddRecipe = new JPanel();
        frameInstruction = new JFrame();
        labelInstruction = new JLabel();
        textAreaInstruction = new JTextArea();


        // ADDRECIPE JTEXTFIELDS CONSTRUCTORS
        recipeNameTextField = new AddPromptTextField(true);
        ingredientsTextField = new AddPromptTextField(true);


        // ADDRECIPE JBUTTON LISTS
        listOfJButtonFoodType = new ArrayList<JButton>();
        listOfJButtonInstruction = new ArrayList<JButton>();
        listOfJButtonDifficulty = new ArrayList<JButton>();
        listOfJButtonMadeBefore = new ArrayList<JButton>();
        listOfJButtonFoodTypeRecipeSearch = new ArrayList<JButton>();
        listOfJButtonAddFoodType = new ArrayList<JButton>();

        // ADDRECIPE JBUTTONFOODTYPE CONSTRUCTORS
        soupButton = new AddRecipeButton("SOUP");
        breakfastButton = new AddRecipeButton("BREAKFAST");
        lunchButton = new AddRecipeButton("LUNCH");
        dinnerButton = new AddRecipeButton("DINNER");
        pastryButton = new AddRecipeButton("PASTRY");
        friedRiceButton = new AddRecipeButton("FRIED RICE");
        // ADDRECIPE MAKEJBUTTON LIST FOODTYPE
        listOfJButtonFoodType.add(soupButton);
        listOfJButtonFoodType.add(breakfastButton);
        listOfJButtonFoodType.add(lunchButton);
        listOfJButtonFoodType.add(dinnerButton);
        listOfJButtonFoodType.add(pastryButton);
        listOfJButtonFoodType.add(friedRiceButton);

        // ADDRECIPE JBUTTONINSTRUCTIONS CONSTRUCTOR
        instructionButton = new AddRecipeButton("ADD INSTRUCTIONS");
        // OPTIONS PAGE ADDRECIPE MAKEJBUTTON LIST INSTRUCTION
        listOfJButtonInstruction.add(instructionButton);

        // ADDRECIPE JBUTTONDIFFICULTY CONSTRUCTORS
        difficulty1Button = new AddRecipeButton("1");
        difficulty2Button = new AddRecipeButton("2");
        difficulty3Button = new AddRecipeButton("3");
        difficulty4Button = new AddRecipeButton("4");
        difficulty5Button = new AddRecipeButton("5");
        // ADDRECIPE MAKEJBUTTON LIST DIFFICULTY
        listOfJButtonDifficulty.add(difficulty1Button);
        listOfJButtonDifficulty.add(difficulty2Button);
        listOfJButtonDifficulty.add(difficulty3Button);
        listOfJButtonDifficulty.add(difficulty4Button);
        listOfJButtonDifficulty.add(difficulty5Button);

        // ADDRECIPE JBUTTONMADEBEFORE CONSTRUCTORS
        yesButton = new AddRecipeButton("Yes");
        noButton = new AddRecipeButton("No");
        // ADDRECIPE MAKEJBUTTON LIST MADE BEFORE
        listOfJButtonMadeBefore.add(yesButton);
        listOfJButtonMadeBefore.add(noButton);

        //ADDRECIPE FOODTYPELISTSTRING CONSTRUCTOR
        givenFoodTypeInString = new ArrayList<>();

        // REMOVERECIPE FRAMES/PANELS/BUTTONS
        frameRemoveRecipe = new JFrame();
        removeTextField = new AddPromptTextField(true);
        panelRemoveRecipe = new JPanel();

        // REMOVERECIPE FRAMES/PANELS/BUTTONS
        framePrintRecipe = new JFrame();
        panelPrintRecipe = new JPanel();

        // FOODTYPERECIPE FRAMES/PANELS/BUTTONS
        soupButton1 = new FoodTypeRecipesButton("SOUP");
        breakfastButton1 = new FoodTypeRecipesButton("BREAKFAST");
        lunchButton1 = new FoodTypeRecipesButton("LUNCH");
        dinnerButton1 = new FoodTypeRecipesButton("DINNER");
        pastryButton1 = new FoodTypeRecipesButton("PASTRY");
        friedRiceButton1 = new FoodTypeRecipesButton("FRIED RICE");
        frameFoodTypeRecipe = new JFrame();
        panelFoodTypeRecipe = new JPanel();
        frameRecipesOfFoodTypeListed = new JFrame();
        panelRecipesOfFoodTypeListed = new JPanel();

        // FOODTYPERECIPE MAKEJBUTTON LIST FOODTYPE
        listOfJButtonFoodTypeRecipeSearch.add(soupButton1);
        listOfJButtonFoodTypeRecipeSearch.add(breakfastButton1);
        listOfJButtonFoodTypeRecipeSearch.add(lunchButton1);
        listOfJButtonFoodTypeRecipeSearch.add(dinnerButton1);
        listOfJButtonFoodTypeRecipeSearch.add(pastryButton1);
        listOfJButtonFoodTypeRecipeSearch.add(friedRiceButton1);

        // RETURNINSTRUCTION FRAMES/PANELS/BUTTONS CONSTRUCTORS
        frameReturnInstruction = new JFrame();
        panelReturnInstruction = new JPanel();
        returnInstructionTextField = new AddPromptTextField(true);
        frameFinalInstruction = new JFrame();
        panelFinalInstruction = new JPanel();

        // EDITDIFFICULTY FRAMES/PANELS/BUTTONS CONSTRUCTORS
        frameEditDifficulty = new JFrame();
        panelEditDifficulty = new JPanel();
        editDifficultyTextField = new AddPromptTextField(true);
        finalEditDifficultyTextField = new AddPromptTextField(true);
        frameFinalEditDifficulty = new JFrame();
        panelFinalEditDifficulty = new JPanel();

        // ADDTYPE FRAMES/PANELS/BUTTONS CONSTRUCTORS
        listOfFoodTypeAddType = new ArrayList<>();
        frameAddType = new JFrame();
        panelAddType = new JPanel();
        soupButton2 = new AddFoodTypeButton("SOUP");
        breakfastButton2 = new AddFoodTypeButton("BREAKFAST");
        lunchButton2 = new AddFoodTypeButton("LUNCH");
        dinnerButton2 = new AddFoodTypeButton("DINNER");
        pastryButton2 = new AddFoodTypeButton("PASTRY");
        friedRiceButton2 = new AddFoodTypeButton("FRIED RICE");
        frameFinalAddType = new JFrame();
        panelFinalAddType = new JPanel();
        addFoodTypePromptTextField = new AddPromptTextField(true);

        // ADDFOODTYPE MAKEJBUTTON LIST FOODTYPE
        listOfJButtonAddFoodType.add(soupButton2);
        listOfJButtonAddFoodType.add(breakfastButton2);
        listOfJButtonAddFoodType.add(lunchButton2);
        listOfJButtonAddFoodType.add(dinnerButton2);
        listOfJButtonAddFoodType.add(pastryButton2);
        listOfJButtonAddFoodType.add(friedRiceButton2);

        // ADDINGREDIENTS FRAMES/PANELS/BUTTONS CONSTRUCTORS
        frameAddIngredients = new JFrame();
        panelAddIngredients = new JPanel();
        addIngredientsPromptTextField = new AddPromptTextField(true);
        frameFinalAddIngredients = new JFrame();
        panelFinalAddIngredients = new JPanel();
        theIngredients = new ArrayList<>();
        finalAddIngredientsTextField = new AddPromptTextField(true);

        // GIVEDETAILS FRAMES/PANELS/BUTTONS CONSTRUCTORS
        frameGiveDetails = new JFrame();
        panelGiveDetails = new JPanel();
        giveDetailsPromptField = new AddPromptTextField(true);
        frameFinalGiveDetails = new JFrame();
        panelFinalGiveDetails = new JPanel();

        // SUBMIT BUTTON CONSTRUCTORS
        addRecipeSubmitButton = new SubmitButton("Submit");
        addInstructionSubmitButton = new SubmitButton("Submit");
        removeRecipeSubmitButton = new SubmitButton("Submit");
        foodTypeRecipeSubmitButton = new SubmitButton("Submit");
        printRecipesDoneButton = new SubmitButton("Done");
        recipesOfFoodTypeListedDoneButton = new SubmitButton("Danke");
        returnInstructionSubmitButton = new SubmitButton("Get Instructions");
        finalInstructionDoneButton = new SubmitButton("Done");
        editDifficultySubmitButton = new SubmitButton("Submit");
        finalEditDifficultySubmitButton = new SubmitButton("Submit");
        addTypeSubmitButton = new SubmitButton("Add Types");
        finalAddTypeDoneButton = new SubmitButton("Done");
        addIngredientsSubmitButton = new SubmitButton("Choose this recipe");
        finalAddIngredientsButton = new SubmitButton("Add ingredients");
        giveDetailsSubmitButton = new SubmitButton("Show details");
        finalGiveDetailsSubmitButton = new SubmitButton("Done");

        addRecipePanel();
        removeRecipePanel();
        foodTypeRecipePanel();

        recipeBookApp = new RecipeBookApp(this);

    }

    private void printAndClearLog() {
        Iterator<Event> it = EventLog.getInstance().iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
        EventLog.getInstance().clear();
    }


    // MAIN TITLE STARTER
    protected void startTitleScreen() {
        add(mainTitleLabel());  // adding the main label
        setVisible(true);
        add(mainTitleButtonNextPage);


    }

    // EFFECTS: creates a main title
    private JLabel mainTitleLabel() {
        ImageIcon mainTitleImage = new ImageIcon("src/main/bonsaiginger.jpeg");
        Image image = mainTitleImage.getImage();
        Image newImage = image.getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH);
        mainTitleImage = new ImageIcon(newImage);
        mainTitle.setText("yOuR rEcIpE bOoK");  // set text of label
        mainTitle.setIcon(mainTitleImage);
        mainTitle.setHorizontalTextPosition(JLabel.CENTER);   // set text LEFT, CENTER, RIGHT of imageicon
        mainTitle.setVerticalTextPosition(JLabel.BOTTOM);   // set text TOP, CENTER, BOTTOM of imageicon
        mainTitle.setForeground(new Color(182, 229, 30));  // set font color
        mainTitle.setFont(MAIN_TITLE_FONT);  // set font of text
        //mainTitle.setIconTextGap(0); // set gap of text to image
        //mainTitle.setBackground(BACKGROUND_COLOUR); // set background color
        //mainTitle.setOpaque(true); // displays background color i.e. makes it visible
        mainTitle.setVerticalAlignment(JLabel.TOP); // set vertical pos of icon+text within label
        mainTitle.setHorizontalAlignment(JLabel.CENTER);  // set horiz. pos of icon+text within label


        Border mainTitleBorder = BorderFactory.createLineBorder(Color.PINK, 10); // creating border
        mainTitle.setBorder(mainTitleBorder); // sets border


        return mainTitle;
    }

    // MODIFIES: this
    // EFFECTS: creates the options frame displaying all features of application
    private JFrame optionsPage() {
        dispose();
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // setting the frame and background
        optionsFrame.setResizable(true);
        optionsFrame.getContentPane().setBackground(BACKGROUND_COLOUR);
        optionsFrame.setVisible(true);
        optionsFrame.add(optionsPanel(), BorderLayout.CENTER);
        optionsFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                printAndClearLog();
                System.exit(0);
            }
        });

        return optionsFrame;
    }

    // EFFECTS: creates the panel for the option buttons on the options frame
    private JPanel optionsPanel() {
        optionsPane.setBackground(BACKGROUND_COLOUR);
        //optionsPane.setBounds(0,200, WIDTH, HEIGHT - 200);  // no need because using BorderLayout function
        optionsPane.setLayout(new GridLayout(11, 1));

        optionsPane.add(addRecipe);
        optionsPane.add(removeRecipe);
        optionsPane.add(printRecipe);
        optionsPane.add(getRecipeOfFoodType);
        optionsPane.add(getInstruction);
        optionsPane.add(editDifficulty);
        optionsPane.add(addType);
        optionsPane.add(addIngredients);
        optionsPane.add(getAllDetails);
        optionsPane.add(saveRecipeBook);
        optionsPane.add(loadRecipeBook);


        return optionsPane;
    }


    // represents a class that opens the options page
    private class GoToOptionsPageButton extends JButton implements ActionListener {


        public GoToOptionsPageButton() {
            super("Open Options Menu");
            setBounds(500, 500, 200, 100);
            addActionListener(this);
            setFocusable(false);  // removes gray lines around text of button
            setFont(SUBTITLE_FONT);
            setForeground(Color.black);
            setBackground(Color.lightGray);
            setOpaque(true);     // sets background to be seen
            setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        }

        // EFFECTS: opens options page from main menu
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == mainTitleButtonNextPage) {
                optionsPage();   // ADD ALL OPTIONS MENU JFRAME
            }
        }

    }

    // represents a class that makes the buttons for the options page
    private class OptionsPageButton extends JButton implements ActionListener {


        public OptionsPageButton(String text) {
            super(text);
            addActionListener(this);
            setText(text);
            setFocusable(false);
            setFont(SUBTITLE_FONT);
            setForeground(Color.BLACK);
            setBackground(Color.lightGray);
            setOpaque(true);
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        }

        // opens the appropriate frame for the different options buttons
        @Override
        @SuppressWarnings("methodlength")
        public void actionPerformed(ActionEvent e) {     /* implement the actionperform for the options page buttons */
            if (e.getSource() == addRecipe) {
                addRecipeFrame();
            }
            if (e.getSource() == removeRecipe) {
                removeRecipeFrame();
            }
            if (e.getSource() == printRecipe) {
                printRecipeFrame();
            }
            if (e.getSource() == getRecipeOfFoodType) {
                foodTypeRecipeFrame();
            }
            if (e.getSource() == getInstruction) {
                returnInstructionFrame();
            }
            if (e.getSource() == editDifficulty) {
                editDifficultyFrame();
            }
            if (e.getSource() == addType) {
                addTypeFrame();
            }
            if (e.getSource() == addIngredients) {
                addIngredientsFrame();
            }
            if (e.getSource() == getAllDetails) {
                giveDetailsFrame();
            }
            if (e.getSource() == saveRecipeBook) {
                saveRecipeBook();
            }
            if (e.getSource() == loadRecipeBook) {
                loadRecipeBook();
            }
        }

    }


    // EFFECTS: creates the add recipe window
    private JFrame addRecipeFrame() {
        frameAddRecipe.setSize(WIDTH / 2, HEIGHT / 2);
        frameAddRecipe.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameAddRecipe.add(panelAddRecipe, BorderLayout.CENTER);
        frameAddRecipe.setVisible(true);

        return frameAddRecipe;
    }

    // EFFECTS: creates the MAIN add recipe panel
    private JPanel addRecipePanel() {
        panelAddRecipe.setBackground(BACKGROUND_COLOUR);
        panelAddRecipe.setLayout(new GridLayout(0, 1));

        panelAddRecipe.add(new AddPromptLabel("What is the recipe name?"));
        panelAddRecipe.add(recipeNameTextField);
        panelAddRecipe.add(new AddPromptLabel("What are the Food Type/s?"));
        panelAddRecipe.add(listOfJButtonToFlowLayoutPanel(listOfJButtonFoodType));
        panelAddRecipe.add(new AddPromptLabel("What are the ingredient/s? (comma-separated list)"));
        panelAddRecipe.add(ingredientsTextField);
        panelAddRecipe.add(listOfJButtonToFlowLayoutPanel(listOfJButtonInstruction));
        panelAddRecipe.add(new AddPromptLabel("How difficult is this recipe?"));
        panelAddRecipe.add(listOfJButtonToFlowLayoutPanel(listOfJButtonDifficulty));
        panelAddRecipe.add(new AddPromptLabel("Have you made this before?"));
        panelAddRecipe.add(listOfJButtonToFlowLayoutPanel(listOfJButtonMadeBefore));
        panelAddRecipe.add(addRecipeSubmitButton);

        return panelAddRecipe;
    }

    // EFFECTS: makes the instruction page frame
    private JFrame instructionFrame() {
        frameInstruction.setSize(WIDTH / (3 / 2), HEIGHT / (3 / 2));
        frameInstruction.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameInstruction.add(instructionLabel(), BorderLayout.NORTH);
        frameInstruction.add(instructionScrollPane(), BorderLayout.CENTER);
        frameInstruction.add(addInstructionSubmitButton, BorderLayout.SOUTH);
        frameInstruction.setVisible(true);                                  /* add submitButton  */
        //frameInstruction.add(, BorderLayout.SOUTH);

        return frameInstruction;
    }

    // EFFECTS: makes the instruction page label
    private JLabel instructionLabel() {
        labelInstruction.setText("INSTRUCTIONS:");
        //labelInstruction.setSize(WIDTH / (3 / 2), HEIGHT / ((1 / 5) * (3 / 2)));
        labelInstruction.setForeground(Color.BLACK);
        labelInstruction.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        labelInstruction.setBackground(new Color(211, 205, 138));
        labelInstruction.setOpaque(true);

        return labelInstruction;
    }

    // EFFECTS: makes the instruction page scroll function
    private JScrollPane instructionScrollPane() {
        scrollPaneInstruction = new JScrollPane(instructionTextArea());
        scrollPaneInstruction.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPaneInstruction.setSize(WIDTH / (3 / 2), HEIGHT / ((3 / 5) * (3 / 2)));

        return scrollPaneInstruction;
    }

    // EFFECTS: makes the instructions page text area
    private JTextArea instructionTextArea() {
        textAreaInstruction.setFont(new Font("Times Roman", Font.PLAIN, 20));
        textAreaInstruction.setForeground(MATRIX_GREEN_TEXT_COLOUR);
        textAreaInstruction.setCaretColor(MATRIX_GREEN_TEXT_COLOUR);
        textAreaInstruction.setBackground(Color.BLACK);

        return textAreaInstruction;
    }


    private JFrame removeRecipeFrame() {
        frameRemoveRecipe.setSize(WIDTH / 2, HEIGHT / 2);
        frameRemoveRecipe.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameRemoveRecipe.add(panelRemoveRecipe);
        frameRemoveRecipe.setVisible(true);

        return frameRemoveRecipe;
    }

    private JPanel removeRecipePanel() {
        panelRemoveRecipe.setBackground(BACKGROUND_COLOUR);
        panelRemoveRecipe.setLayout(new GridLayout(0, 1));

        panelRemoveRecipe.add(new AddPromptLabel("Enter recipe to be deleted:"));
        panelRemoveRecipe.add(removeTextField);
        panelRemoveRecipe.add(removeRecipeSubmitButton);

        return panelRemoveRecipe;
    }

    private JFrame printRecipeFrame() {
        framePrintRecipe = new JFrame();
        framePrintRecipe.setSize(WIDTH / 2, HEIGHT / 2);
        framePrintRecipe.getContentPane().setBackground(BACKGROUND_COLOUR);
        framePrintRecipe.add(printRecipePanel());
        framePrintRecipe.setVisible(true);

        return framePrintRecipe;
    }

    private JPanel printRecipePanel() {
        panelPrintRecipe = new JPanel();
        panelPrintRecipe.setBackground(BACKGROUND_COLOUR);
        panelPrintRecipe.setLayout(new GridLayout(0, 1));
        JTextField printTextField = new AddPromptTextField(false);
        String print = recipeBookApp.recipeBook.printRecipeNames();
        printTextField.setText(print);

        panelPrintRecipe.add(new AddPromptLabel("Recipes in your recipe book:"));
        panelPrintRecipe.add(printTextField);
        panelPrintRecipe.add(printRecipesDoneButton);

        return panelPrintRecipe;
    }

    // EFFECTS: creates the food type find recipes window
    private JFrame foodTypeRecipeFrame() {
        frameFoodTypeRecipe.setSize(WIDTH / 2, HEIGHT / 2);
        frameFoodTypeRecipe.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameFoodTypeRecipe.add(panelFoodTypeRecipe, BorderLayout.CENTER);
        frameFoodTypeRecipe.setVisible(true);

        return frameFoodTypeRecipe;
    }

    // EFFECTS: creates the MAIN food type recipes panel
    private JPanel foodTypeRecipePanel() {
        panelFoodTypeRecipe.setBackground(BACKGROUND_COLOUR);
        panelFoodTypeRecipe.setLayout(new GridLayout(0, 1));

        panelFoodTypeRecipe.add(new AddPromptLabel("What type of recipes are you looking for?"));
        panelFoodTypeRecipe.add(listOfJButtonToFlowLayoutPanel(listOfJButtonFoodTypeRecipeSearch));
        panelFoodTypeRecipe.add(foodTypeRecipeSubmitButton);

        return panelFoodTypeRecipe;
    }

    private JFrame recipesOfFoodTypeListedFrame(FoodType foodType) {
        frameRecipesOfFoodTypeListed = new JFrame();
        frameRecipesOfFoodTypeListed.setSize(WIDTH / 2, HEIGHT / 2);
        frameRecipesOfFoodTypeListed.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameRecipesOfFoodTypeListed.add(recipesOfFoodTypeListedPanel(foodType));
        frameRecipesOfFoodTypeListed.setVisible(true);

        return frameRecipesOfFoodTypeListed;
    }

    private JPanel recipesOfFoodTypeListedPanel(FoodType foodType) {
        panelRecipesOfFoodTypeListed = new JPanel();
        panelRecipesOfFoodTypeListed.setBackground(BACKGROUND_COLOUR);
        panelRecipesOfFoodTypeListed.setLayout(new GridLayout(0, 1));
        JTextField printTextField = new AddPromptTextField(false);
        String print = recipeBookApp.recipeBook.listOfFoodString(foodType);
        printTextField.setText(print);

        panelRecipesOfFoodTypeListed.add(new AddPromptLabel("Recipes in your recipe book of chosen food type:"));
        panelRecipesOfFoodTypeListed.add(printTextField);
        panelRecipesOfFoodTypeListed.add(recipesOfFoodTypeListedDoneButton);

        return panelRecipesOfFoodTypeListed;
    }

    private JFrame returnInstructionFrame() {
        frameReturnInstruction = new JFrame();
        frameReturnInstruction.setSize(WIDTH / 2, HEIGHT / 2);
        frameReturnInstruction.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameReturnInstruction.add(returnInstructionPanel());
        frameReturnInstruction.setVisible(true);

        return frameReturnInstruction;
    }

    private JPanel returnInstructionPanel() {
        panelReturnInstruction = new JPanel();
        panelReturnInstruction.setBackground(BACKGROUND_COLOUR);
        panelReturnInstruction.setLayout(new GridLayout(0, 1));

        panelReturnInstruction.add(new AddPromptLabel("Enter recipe name (case-sensitive)"));
        panelReturnInstruction.add(returnInstructionTextField);
        panelReturnInstruction.add(returnInstructionSubmitButton);

        return panelReturnInstruction;
    }

    private JFrame finalInstructionFrame() {
        frameFinalInstruction = new JFrame();
        frameFinalInstruction.setSize(WIDTH / 2, HEIGHT / 2);
        frameFinalInstruction.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameFinalInstruction.add(finalInstructionPanel());
        frameFinalInstruction.setVisible(true);

        return frameFinalInstruction;
    }

    private JPanel finalInstructionPanel() {
        panelFinalInstruction = new JPanel();
        panelFinalInstruction.setBackground(BACKGROUND_COLOUR);
        panelFinalInstruction.setLayout(new GridLayout(0, 1));
        JTextField printTextField = new AddPromptTextField(false);
        String print = returnedRecipe;
        printTextField.setText(print);

        panelFinalInstruction.add(new AddPromptLabel(returnedRecipe + " " + "instructions:"));
        panelFinalInstruction.add(printTextField);
        panelFinalInstruction.add(finalInstructionDoneButton);

        return panelFinalInstruction;
    }

    private void returnInstruction() {
        returnedRecipe =
                recipeBookApp.recipeBook.returnRecipeInstruction(returnInstructionTextField.getText());
        if (returnInstructionTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "No recipe written on text field", "ERROR!!!",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!returnedRecipe.equals("The recipe does not exist")) {
            finalInstructionFrame();
        } else {
            JOptionPane.showMessageDialog(null,
                    "The recipe does not exist", "ERROR!!!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private JFrame editDifficultyFrame() {
        frameEditDifficulty = new JFrame();
        frameEditDifficulty.setSize(WIDTH / 2, HEIGHT / 2);
        frameEditDifficulty.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameEditDifficulty.add(editDifficultyPanel());
        frameEditDifficulty.setVisible(true);

        return frameEditDifficulty;
    }

    private JPanel editDifficultyPanel() {
        panelEditDifficulty = new JPanel();
        panelEditDifficulty.setBackground(BACKGROUND_COLOUR);
        panelEditDifficulty.setLayout(new GridLayout(0, 1));

        panelEditDifficulty.add(new AddPromptLabel("Enter recipe name (case-sensitive)"));
        panelEditDifficulty.add(editDifficultyTextField);
        panelEditDifficulty.add(editDifficultySubmitButton);

        return panelEditDifficulty;
    }

    private JFrame finalEditDifficultyFrame() {
        frameFinalEditDifficulty = new JFrame();
        frameFinalEditDifficulty.setSize(WIDTH / 2, HEIGHT / 2);
        frameFinalEditDifficulty.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameFinalEditDifficulty.add(finalEditDifficultyPanel());
        frameFinalEditDifficulty.setVisible(true);

        return frameFinalEditDifficulty;
    }

    private JPanel finalEditDifficultyPanel() {
        panelFinalEditDifficulty = new JPanel();
        panelFinalEditDifficulty.setBackground(BACKGROUND_COLOUR);
        panelFinalEditDifficulty.setLayout(new GridLayout(0, 1));
        String theName = difficultyRecipe.getRecipeName();
        int theDifficulty = difficultyRecipe.getDifficulty();


        panelFinalEditDifficulty.add(new AddPromptLabel(theName + " has a difficulty of "
                + String.valueOf(theDifficulty) + ", set its new difficulty (1-5):"));
        panelFinalEditDifficulty.add(finalEditDifficultyTextField);
        panelFinalEditDifficulty.add(finalEditDifficultySubmitButton);

        return panelFinalEditDifficulty;
    }


    private void editDifficulty() {
        difficultyRecipe = recipeBookApp.recipeBook.returnRecipe(editDifficultyTextField.getText());
        if (editDifficultyTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No recipe written on text field",
                    "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            ;
        } else if (difficultyRecipe == null) {
            JOptionPane.showMessageDialog(null, "The recipe does not exist", "ERROR!!!",
                    JOptionPane.ERROR_MESSAGE);
            ;
        } else {
            finalEditDifficultyFrame();
        }
    }

    private JFrame addTypeFrame() {
        frameAddType = new JFrame();
        frameAddType.setSize(WIDTH / 2, HEIGHT / 2);
        frameAddType.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameAddType.add(addTypePanel());
        frameAddType.setVisible(true);

        return frameAddType;
    }

    private JPanel addTypePanel() {
        panelAddType = new JPanel();
        addFoodTypePromptTextField = new AddPromptTextField(true);
        listOfFoodTypeAddType = new ArrayList<>();
        panelAddType.setBackground(BACKGROUND_COLOUR);
        panelAddType.setLayout(new GridLayout(0, 1));

        panelAddType.add(new AddPromptLabel("Enter recipe name (case-sensitive) "
                + "and choose food types to be added"));
        panelAddType.add(addFoodTypePromptTextField);
        panelAddType.add(listOfJButtonToFlowLayoutPanel(listOfJButtonAddFoodType));
        panelAddType.add(addTypeSubmitButton);

        return panelAddType;
    }

    private JFrame finalAddTypeFrame() {
        frameFinalAddType = new JFrame();
        frameFinalAddType.setSize(WIDTH / 2, HEIGHT / 2);
        frameFinalAddType.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameFinalAddType.add(finalAddTypePanel());
        frameFinalAddType.setVisible(true);

        return frameFinalAddType;
    }

    private JPanel finalAddTypePanel() {
        panelFinalAddType = new JPanel();
        panelFinalAddType.setBackground(BACKGROUND_COLOUR);
        panelFinalAddType.setLayout(new GridLayout(0, 1));
        Recipe theRecipe = recipeBookApp.recipeBook.returnRecipe(addFoodTypePromptTextField.getText());
        String theName = theRecipe.getRecipeName();
        theRecipe.setType(listOfFoodTypeAddType);
        List<FoodType> theType = theRecipe.getType();
        JTextField printTextField = new AddPromptTextField(false);
        String print = foodTypesToListOfString(theType);
        printTextField.setText(print);

        panelFinalAddType.add(new AddPromptLabel(theName + " is now of the following food types:"));
        panelFinalAddType.add(printTextField);
        panelFinalAddType.add(finalAddTypeDoneButton);

        return panelFinalAddType;
    }

    private String foodTypesToListOfString(List<FoodType> foodTypes) {
        List<String> stringList = new ArrayList<>();
        for (FoodType t : foodTypes) {
            stringList.add(t.toString());
        }
        return String.join(", ", stringList);
    }

    private JFrame addIngredientsFrame() {
        frameAddIngredients = new JFrame();
        frameAddIngredients.setSize(WIDTH / 2, HEIGHT / 2);
        frameAddIngredients.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameAddIngredients.add(addIngredientsPanel());
        frameAddIngredients.setVisible(true);

        return frameAddIngredients;
    }

    private JPanel addIngredientsPanel() {
        panelAddIngredients = new JPanel();
        panelAddIngredients.setBackground(BACKGROUND_COLOUR);
        panelAddIngredients.setLayout(new GridLayout(0, 1));

        panelAddIngredients.add(new AddPromptLabel("Enter recipe name (case-sensitive) "
                + "and choose food types to be added"));
        panelAddIngredients.add(addIngredientsPromptTextField);
        panelAddIngredients.add(addIngredientsSubmitButton);

        return panelAddIngredients;
    }

    private JFrame finalAddIngredientsFrame() {
        frameFinalAddIngredients = new JFrame();
        frameFinalAddIngredients.setSize(WIDTH / 2, HEIGHT / 2);
        frameFinalAddIngredients.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameFinalAddIngredients.add(finalAddIngredientsPanel());
        frameFinalAddIngredients.setVisible(true);

        return frameFinalAddIngredients;
    }

    private JPanel finalAddIngredientsPanel() {
        panelFinalAddIngredients = new JPanel();
        panelFinalAddIngredients.setBackground(BACKGROUND_COLOUR);
        panelFinalAddIngredients.setLayout(new GridLayout(0, 1));
        Recipe theRecipe = recipeBookApp.recipeBook.returnRecipe(addIngredientsPromptTextField.getText());
        String theName = theRecipe.getRecipeName();

        panelFinalAddIngredients.add(new AddPromptLabel("Add ingredients to " + theName
                + " (comma-separated list):"));
        panelFinalAddIngredients.add(finalAddIngredientsTextField);
        panelFinalAddIngredients.add(finalAddIngredientsButton);

        return panelFinalAddIngredients;
    }

    private JFrame giveDetailsFrame() {
        frameGiveDetails = new JFrame();
        frameGiveDetails.setSize(WIDTH / 2, HEIGHT / 2);
        frameGiveDetails.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameGiveDetails.add(giveDetailsPanel());
        frameGiveDetails.setVisible(true);

        return frameGiveDetails;
    }

    private JPanel giveDetailsPanel() {
        panelGiveDetails = new JPanel();
        panelGiveDetails.setBackground(BACKGROUND_COLOUR);
        panelGiveDetails.setLayout(new GridLayout(0, 1));

        panelGiveDetails.add(new AddPromptLabel("Enter recipe name (case-sensitive)"));
        panelGiveDetails.add(giveDetailsPromptField);
        panelGiveDetails.add(giveDetailsSubmitButton);

        return panelGiveDetails;
    }

    private JFrame finalGiveDetailsFrame() {
        frameFinalGiveDetails = new JFrame();
        frameFinalGiveDetails.setSize(WIDTH / 2, HEIGHT / 2);
        frameFinalGiveDetails.getContentPane().setBackground(BACKGROUND_COLOUR);
        frameFinalGiveDetails.add(finalGiveDetailsPanel());
        frameFinalGiveDetails.setVisible(true);

        return frameFinalGiveDetails;
    }

    private JPanel finalGiveDetailsPanel() {
        panelFinalGiveDetails = new JPanel();
        panelFinalGiveDetails.setBackground(BACKGROUND_COLOUR);
        panelFinalGiveDetails.setLayout(new GridLayout(0, 1));
        Recipe theRecipe = recipeBookApp.recipeBook.returnRecipe(giveDetailsPromptField.getText());
        String theName = theRecipe.getRecipeName();
        JTextField printTextField = new AddPromptTextField(false);
        String print = theRecipe.getAllDetails();
        printTextField.setText(print);

        panelFinalGiveDetails.add(new AddPromptLabel("FULL RECIPE FOR " + theName + ":"));
        panelFinalGiveDetails.add(printTextField);
        panelFinalGiveDetails.add(finalGiveDetailsSubmitButton);

        giveDetailsPromptField.setText("");

        return panelFinalGiveDetails;
    }


    // represents a class that makes the submitButton
    private class SubmitButton extends JButton implements ActionListener {

        public SubmitButton(String text) {
            super(text);
            //setSize(WIDTH / (3 / 2), HEIGHT / ((1 / 5) * (3 / 2)));
            addActionListener(this);  // ADD ACTION LISTENER
            setFocusable(false);
            setForeground(Color.BLACK);
            setBackground(LIGHTER_BACKGROUND_COLOUR);
            setBorder(BorderFactory.createLineBorder(DARKER_BACKGROUND_COLOUR, 2));
        }

        // gives submitButton function
        @Override
        @SuppressWarnings("methodlength")
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addRecipeSubmitButton) {
                if (recipeNameTextField.getText().equals("") || givenFoodTypeInString.isEmpty()
                        || ingredientsTextField.getText().equals("") || textAreaInstruction.getText().equals("")
                        || givenDifficulty == 0) {
                    JOptionPane.showMessageDialog(null, "missing fields", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    addRecipe();
                }                                          /* edit JOptionPane  */
            }
            if (e.getSource() == addInstructionSubmitButton) {
                if (textAreaInstruction.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "missing fields", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    frameInstruction.dispose();
                    textAreaInstruction.getText();
                }
            }
            if (e.getSource() == removeRecipeSubmitButton) {
                if (removeTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "missing fields", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Recipe newRecipe = recipeBookApp.recipeBook.returnRecipe(removeTextField.getText());
                    if (newRecipe == null) {
                        JOptionPane.showMessageDialog(null,
                                "Recipe could not be deleted; recipe does not exist", "ERROR!!!",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        removeRecipe(newRecipe);
                    }
                }
            }
            if (e.getSource() == foodTypeRecipeSubmitButton) {
                if (currentFoodTypeRecipeSearch == null) {
                    JOptionPane.showMessageDialog(null, "No button clicked", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    FoodType foodType = recipeBookApp.stringToType(currentFoodTypeRecipeSearch.toLowerCase());
                    if (recipeBookApp.recipeBook.listOfFoodString(foodType) == null) {
                        JOptionPane.showMessageDialog(null,
                                "No recipe of this food type exists", "ERROR!!!",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        recipesOfFoodTypeListedFrame(foodType);
                    }
                    currentFoodTypeRecipeSearch = null;
                }
            }
            if (e.getSource() == recipesOfFoodTypeListedDoneButton) {
                frameRecipesOfFoodTypeListed.dispose();
                frameFoodTypeRecipe.dispose();
            }
            if (e.getSource() == printRecipesDoneButton) {
                framePrintRecipe.dispose();
            }
            if (e.getSource() == returnInstructionSubmitButton) {
                returnInstruction();
                returnInstructionTextField.setText("");
                frameReturnInstruction.dispose();
            }
            if (e.getSource() == finalInstructionDoneButton) {
                frameFinalInstruction.dispose();
                returnedRecipe = "";
            }
            if (e.getSource() == editDifficultySubmitButton) {
                editDifficulty();
                editDifficultyTextField.setText("");
                JOptionPane.showMessageDialog(null,
                        "Only accepts whole numbers 1-5", "ERROR!!!",
                        JOptionPane.INFORMATION_MESSAGE);
                frameEditDifficulty.dispose();
            }
            if (e.getSource() == finalEditDifficultySubmitButton) {
                int difficulty = Integer.parseInt(finalEditDifficultyTextField.getText());
                if (difficulty > 0 && difficulty < 6) {
                    difficultyRecipe.setDifficulty(difficulty);
                    frameFinalEditDifficulty.dispose();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Not a valid value, please try again.", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
            if (e.getSource() == addTypeSubmitButton) {
                if (listOfFoodTypeAddType.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "No food types clicked", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }
                if (addFoodTypePromptTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "No recipe written in text field", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else if (recipeBookApp.recipeBook.returnRecipe(addFoodTypePromptTextField.getText()) == null) {
                    JOptionPane.showMessageDialog(null,
                            "The recipe does not exist", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    finalAddTypeFrame();
                    frameAddType.dispose();
                }
            }
            if (e.getSource() == finalAddTypeDoneButton) {
                frameFinalAddType.dispose();
            }
            if (e.getSource() == addIngredientsSubmitButton) {
                if (addIngredientsPromptTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "No recipe is written on the text field", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else if (recipeBookApp.recipeBook.returnRecipe(addIngredientsPromptTextField.getText()) == null) {
                    JOptionPane.showMessageDialog(null,
                            "The recipe does not exist", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                    addIngredientsPromptTextField.setText("");
                } else {
                    finalAddIngredientsFrame();
                    frameAddIngredients.dispose();
                }
            }
            if (e.getSource() == finalAddIngredientsButton) {
                if (finalAddIngredientsTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "There are no ingredients written on the text field", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Recipe thisRecipe = recipeBookApp.recipeBook.returnRecipe(addIngredientsPromptTextField.getText());
                    theIngredients = Arrays.asList(finalAddIngredientsTextField.getText().split(", "));
                    thisRecipe.setIngredients(theIngredients);
                    frameFinalAddIngredients.dispose();
                    addIngredientsPromptTextField.setText("");
                    theIngredients = new ArrayList<>();
                    finalAddIngredientsTextField.setText("");
                }
            }
            if (e.getSource() == giveDetailsSubmitButton) {
                if (giveDetailsPromptField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "No recipe written on the text field", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                } else if (recipeBookApp.recipeBook.returnRecipe(giveDetailsPromptField.getText()) == null) {
                    JOptionPane.showMessageDialog(null,
                            "The recipe does not exist", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                    giveDetailsPromptField.setText("");
                } else {
                    finalGiveDetailsFrame();
                    frameGiveDetails.dispose();
                }
            }
            if (e.getSource() == finalGiveDetailsSubmitButton) {
                frameFinalGiveDetails.dispose();
            }
        }


        private void removeRecipe(Recipe newRecipe) {
            frameRemoveRecipe.dispose();
            recipeBookApp.recipeBook.removeRecipe(newRecipe);
            JOptionPane.showMessageDialog(null,
                    "Recipe removed successfully", "ERROR!!!",
                    JOptionPane.INFORMATION_MESSAGE);
            removeTextField.setText("");
        }

        private void addRecipe() {
            frameAddRecipe.dispose();
            ArrayList<FoodType> emptyType = new ArrayList<>();
            List<String> ingredients =
                    new ArrayList<>(Arrays.asList(ingredientsTextField.getText().split(", ")));
            Recipe newRecipe = new Recipe(recipeNameTextField.getText(), emptyType, ingredients,
                    textAreaInstruction.getText(), givenDifficulty, givenHasMade);
            newRecipe.setType(givenFoodTypeInString);
            recipeBookApp.recipeBook.addRecipe(newRecipe);
            // resets values
            recipeNameTextField.setText("");
            givenFoodTypeInString = new ArrayList<>();
            ingredientsTextField.setText("");
            textAreaInstruction.setText("");
            givenDifficulty = 0;
            givenHasMade = false;
        }

    }

    // to make labels for function pages
    private class AddPromptLabel extends JLabel {


        public AddPromptLabel(String text) {
            super(text);
            setHorizontalAlignment(JLabel.CENTER);
            setForeground(Color.BLACK);
            setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            setBackground(BACKGROUND_COLOUR);
            setOpaque(true);

        }
    }

    // to make buttons for the add recipe
    private class AddRecipeButton extends JButton implements ActionListener {


        public AddRecipeButton(String text) {
            super(text);
            addActionListener(this);  // ADD ACTION LISTENER
            setFocusable(false);
            setFont(new Font("Monospaced", Font.BOLD, 20));
            setForeground(Color.BLACK);
            setBackground(LIGHTER_BACKGROUND_COLOUR);
            setBorder(BorderFactory.createLineBorder(DARKER_BACKGROUND_COLOUR, 2));
        }

        // gives function to the add recipe buttons
        @Override
        @SuppressWarnings("methodlength")
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == difficulty1Button) {
                givenDifficulty = 1;
            }
            if (e.getSource() == difficulty2Button) {
                givenDifficulty = 2;
            }
            if (e.getSource() == difficulty3Button) {
                givenDifficulty = 3;
            }
            if (e.getSource() == difficulty4Button) {
                givenDifficulty = 4;
            }
            if (e.getSource() == difficulty5Button) {
                givenDifficulty = 5;
            }
            if (e.getSource() == soupButton) {
                inListOfFoodType("soup");
            }
            if (e.getSource() == breakfastButton) {
                inListOfFoodType("breakfast");
            }
            if (e.getSource() == lunchButton) {
                inListOfFoodType("lunch");
            }
            if (e.getSource() == dinnerButton) {
                inListOfFoodType("dinner");
            }
            if (e.getSource() == pastryButton) {
                inListOfFoodType("pastry");
            }
            if (e.getSource() == friedRiceButton) {
                inListOfFoodType("fried rice");
            }
            if (e.getSource() == yesButton) {
                givenHasMade = true;
            }
            if (e.getSource() == noButton) {
                givenHasMade = false;
            }
            if (e.getSource() == instructionButton) {
                instructionFrame();

            }
        }
    }

    // to make buttons for the add recipe
    private class FoodTypeRecipesButton extends JButton implements ActionListener {


        public FoodTypeRecipesButton(String text) {
            super(text);
            addActionListener(this);  // ADD ACTION LISTENER
            setFocusable(false);
            setFont(new Font("Monospaced", Font.BOLD, 20));
            setForeground(Color.BLACK);
            setBackground(LIGHTER_BACKGROUND_COLOUR);
            setBorder(BorderFactory.createLineBorder(DARKER_BACKGROUND_COLOUR, 2));
        }

        // gives function to the add recipe buttons
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == soupButton1) {
                currentFoodTypeRecipeSearch = "Soup";
            }
            if (e.getSource() == breakfastButton1) {
                currentFoodTypeRecipeSearch = "Breakfast";
            }
            if (e.getSource() == lunchButton1) {
                currentFoodTypeRecipeSearch = "Lunch";
            }
            if (e.getSource() == dinnerButton1) {
                currentFoodTypeRecipeSearch = "Dinner";
            }
            if (e.getSource() == pastryButton1) {
                currentFoodTypeRecipeSearch = "Pastry";
            }
            if (e.getSource() == friedRiceButton1) {
                currentFoodTypeRecipeSearch = "Fried Rice";
            }

        }
    }


    private class AddFoodTypeButton extends JButton implements ActionListener {

        public AddFoodTypeButton(String text) {
            super(text);
            addActionListener(this);  // ADD ACTION LISTENER
            setFocusable(false);
            setFont(new Font("Monospaced", Font.BOLD, 20));
            setForeground(Color.BLACK);
            setBackground(LIGHTER_BACKGROUND_COLOUR);
            setBorder(BorderFactory.createLineBorder(DARKER_BACKGROUND_COLOUR, 2));

        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == soupButton2) {
                listOfFoodTypeAddType.add("soup");
            }
            if (e.getSource() == breakfastButton2) {
                listOfFoodTypeAddType.add("breakfast");
            }
            if (e.getSource() == lunchButton2) {
                listOfFoodTypeAddType.add("lunch");
            }
            if (e.getSource() == dinnerButton2) {
                listOfFoodTypeAddType.add("dinner");
            }
            if (e.getSource() == pastryButton2) {
                listOfFoodTypeAddType.add("pastry");
            }
            if (e.getSource() == friedRiceButton2) {
                listOfFoodTypeAddType.add("fried rice");
            }
        }
    }

    //EFFECTS: puts the food type string into the list of string
    public void inListOfFoodType(String s) {
        if (!givenFoodTypeInString.contains(s)) {
            givenFoodTypeInString.add(s);
        }
    }


    // to make text fields for the function pages
    private class AddPromptTextField extends JTextField {


        public AddPromptTextField(boolean b) {
            super();
            setFont(new Font("Times Roman", Font.PLAIN, 20));
            setForeground(MATRIX_GREEN_TEXT_COLOUR);
            setCaretColor(MATRIX_GREEN_TEXT_COLOUR);
            setBackground(Color.BLACK);
            setEditable(b);
        }
    }

    // EFFECTS: takes listOfJButtons and adds them to a flowLayout Panel
    private JPanel listOfJButtonToFlowLayoutPanel(ArrayList<JButton> buttons) {
        JPanel thePanel = new JPanel();
        thePanel.setBackground(BACKGROUND_COLOUR);
        thePanel.setLayout(new FlowLayout());

        for (JButton b : buttons) {
            thePanel.add(b);
        }

        return thePanel;
    }

    // EFFECTS: saves the RecipeBook to file
    private void saveRecipeBook() {
        try {
            recipeBookApp.jsonWriter.open();
            recipeBookApp.jsonWriter.write(recipeBookApp.recipeBook);
            recipeBookApp.jsonWriter.close();
            System.out.println("Saved recipe book to " + recipeBookApp.JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + recipeBookApp.JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads RecipeBook from file
    private void loadRecipeBook() {
        try {
            recipeBookApp.recipeBook = recipeBookApp.jsonReader.read();
            System.out.println("Loaded recipe book from " + recipeBookApp.JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + recipeBookApp.JSON_STORE);
        }
    }


}







