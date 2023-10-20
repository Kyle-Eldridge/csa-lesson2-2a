package com.codedotorg;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ByteBud {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The text box that displays the conversation */
    private TextArea conversation;

    /** The text box for the user to enter their response */
    private TextField inputField;

    /**
     * Constructs a new ByteBud object with the given Stage window, width and height.
     * Initializes a TextArea for conversation and sets it to wrap text.
     * Creates an input field using the createInputField() method.
     *
     * @param window the Stage window to display the ByteBud conversation
     * @param width the width of the ByteBud conversation window
     * @param height the height of the ByteBud conversation window
     */
    public ByteBud(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        conversation = new TextArea("");
        conversation.setWrapText(true);

        inputField = createInputField();
    }
    
    /**
     * Sets the title of the window to "ByteBud", creates the main scene, adds the
     * stylesheet to the scene, sets the scene to the window, and shows the window.
     */
    public void startApp() {
        window.setTitle("ByteBud");
        
        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene for the ByteBud application.
     * 
     * @return the main scene
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("ByteBud");
        titleLabel.setId("titleLabel");

        HBox inputLayout = createInputLayout();

        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(titleLabel, conversation, inputLayout);

        Scene mainScene = new Scene(mainLayout, width, height);
        
        return mainScene;
    }

    /**
     * Creates an HBox layout that contains a Label and an input field.
     * The Label displays the text "Type here: ".
     * 
     * @return the HBox layout containing the Label and input field
     */
    public HBox createInputLayout() {
        Label inputLabel = new Label("Type here: ");
        inputLabel.setPadding(new Insets(0, 5, 0, 0));

        HBox tempLayout = new HBox();
        tempLayout.getChildren().addAll(inputLabel, inputField);
        tempLayout.setAlignment(Pos.CENTER);
        
        return tempLayout;
    }

    /**
     * Creates a TextField for user input and sets an action
     * event to update the user and bot responses.
     * 
     * @return the created TextField
     */
    public TextField createInputField() {
        TextField tempField = new TextField();

        tempField.setOnAction(event -> {
            String userInput = tempField.getText();

            updateUserResponse(userInput);
            updateBotResponse(userInput);

            tempField.clear();
        });

        return tempField;
    }

    /**
     * Updates the conversation text with the user's input.
     * 
     * @param userInput the input provided by the user
     */
    public void updateUserResponse(String userInput) {
        conversation.appendText("You: " + userInput + "\n");
    }

    /**
     * Updates the bot response based on the user input.
     * 
     * @param userInput the input provided by the user
     */
    public void updateBotResponse(String userInput) {
        String botResponse = getResponse(userInput);
        conversation.appendText("ByteBud: " + botResponse + "\n");
    }

/**
 * The input text is first converted to lower case to ensure case-insensitive matching.
 * If the input text doesn't match any of the predefined phrases, a default message is
 * returned indicating that the bot didn't understand the input.
 * @param inputText The user's input text.
 * @return A string containing the bot's response.
 */
private String getResponse(String inputText) {
    String response = "";
    String lowerCaseInput = inputText.toLowerCase();
    
    if (lowerCaseInput.contains("hello")) {
        response = "Hi there!";
    } else if (lowerCaseInput.contains("how are you")) {
        response = "I'm doing well, thank you for asking.";
    } else if (lowerCaseInput.contains("what is your name")) {
        response = "My name is ByteBud.";
    } else if (lowerCaseInput.contains("what time is it")) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        response = "The current time is " + currentTime.format(formatter) + ".";
    } else if (lowerCaseInput.contains("how old are you")) {
        response = "I'm a computer program, I don't have an age.";
    } else if (lowerCaseInput.contains("what is the meaning of life")) {
        response = "That's a philosophical question, I'm not sure I can answer that.";
    } else if (lowerCaseInput.contains("who created you")) {
        response = "I was created by a team of developers at ByteBud Inc.";
    } else if (lowerCaseInput.contains("what is your purpose")) {
        response = "My purpose is to assist you with your tasks and answer your questions.";
    } else if (lowerCaseInput.contains("what is the weather like")) {
        response = "I'm sorry, I don't have access to real-time weather information.";
    } else if (lowerCaseInput.contains("what is the capital of France")) {
        response = "The capital of France is Paris.";
    } else if (lowerCaseInput.contains("what is the largest country in the world")) {
        response = "The largest country in the world is Russia.";
    } else if (lowerCaseInput.contains("what is the smallest country in the world")) {
        response = "The smallest country in the world is Vatican City.";
    } else if (lowerCaseInput.contains("what is the tallest mountain in the world")) {
        response = "The tallest mountain in the world is Mount Everest.";
    } else if (lowerCaseInput.contains("what is the deepest ocean in the world")) {
        response = "The deepest ocean in the world is the Pacific Ocean.";
    } else if (lowerCaseInput.contains("what is the largest animal in the world")) {
        response = "The largest animal in the world is the blue whale.";
    } else if (lowerCaseInput.contains("what is the fastest land animal in the world")) {
        response = "The fastest land animal in the world is the cheetah.";
    } else if (lowerCaseInput.contains("what is the largest bird in the world")) {
        response = "The largest bird in the world is the ostrich.";
    } else if (lowerCaseInput.contains("what is the longest river in the world")) {
        response = "The longest river in the world is the Nile River.";
    } else if (lowerCaseInput.contains("what is the highest waterfall in the world")) {
        response = "The highest waterfall in the world is Angel Falls in Venezuela.";
    } else if (lowerCaseInput.contains("what is the largest desert in the world")) {
        response = "The largest desert in the world is the Sahara Desert.";
    } else if (lowerCaseInput.contains("what is the largest lake in the world")) {
        response = "The largest lake in the world is the Caspian Sea.";
    } else if (lowerCaseInput.contains("what is the largest island in the world")) {
        response = "The largest island in the world is Greenland.";
    } else if (lowerCaseInput.contains("what is the largest volcano in the world")) {
        response = "The largest volcano in the world is Mauna Loa in Hawaii.";
    } else if (lowerCaseInput.contains("what is the largest waterfall in the world")) {
        response = "The largest waterfall in the world is Victoria Falls in Africa.";
    } else if (lowerCaseInput.contains("what is the largest flower in the world")) {
        response = "The largest flower in the world is the Rafflesia arnoldii.";
    } else if (lowerCaseInput.contains("what is the largest spider in the world")) {
        response = "The largest spider in the world is the Goliath bird-eating spider.";
    } else if (lowerCaseInput.contains("what is the largest fish in the world")) {
        response = "The largest fish in the world is the whale shark.";
    } else if (lowerCaseInput.contains("what is the largest reptile in the world")) {
        response = "The largest reptile in the world is the saltwater crocodile.";
    } else if (lowerCaseInput.contains("what is the largest mammal in the world")) {
        response = "The largest mammal in the world is the blue whale.";
    } else if (lowerCaseInput.contains("what is the largest bird of prey in the world")) {
        response = "The largest bird of prey in the world is the Andean condor.";
    } else if (lowerCaseInput.contains("what is the largest rodent in the world")) {
        response = "The largest rodent in the world is the capybara.";
    } else if (lowerCaseInput.contains("what is the largest carnivorous marsupial in the world")) {
        response = "The largest carnivorous marsupial in the world is the Tasmanian devil.";
    } else if (lowerCaseInput.contains("what is the largest land animal in the world")) {
        response = "The largest land animal in the world is the African elephant.";
    } else if (lowerCaseInput.contains("what is the largest bird in North America")) {
        response = "The largest bird in North America is the California condor.";
    } else if (lowerCaseInput.contains("what is the largest bird in South America")) {
        response = "The largest bird in South America is the ostrich.";
    } else if (lowerCaseInput.contains("what is the largest bird in Australia")) {
        response = "The largest bird in Australia is the emu.";
    } else if (lowerCaseInput.contains("what is the largest bird in Africa")) {
        response = "The largest bird in Africa is the ostrich.";
    } else if (lowerCaseInput.contains("what is the largest bird in Asia")) {
        response = "The largest bird in Asia is the ostrich.";
    } else if (lowerCaseInput.contains("what is the largest bird in Europe")) {
        response = "The largest bird in Europe is the common ostrich.";
    } else if (lowerCaseInput.contains("what is the largest bird in Antarctica")) {
        response = "The largest bird in Antarctica is the emperor penguin.";
    } else if (lowerCaseInput.contains("what is the largest bird in the world")) {
        response = "The largest bird in the world is the ostrich.";
    } else if (lowerCaseInput.contains("what is the smallest bird in the world")) {
        response = "The smallest bird in the world is the bee hummingbird.";
    } else if (lowerCaseInput.contains("what is the smallest mammal in the world")) {
        response = "The smallest mammal in the world is the bumblebee bat.";
    } else if (lowerCaseInput.contains("what is the smallest fish in the world")) {
        response = "The smallest fish in the world is the Paedocypris fish.";
    } else if (lowerCaseInput.contains("what is the smallest reptile in the world")) {
        response = "The smallest reptile in the world is the dwarf gecko.";
    } else if (lowerCaseInput.contains("what is the smallest insect in the world")) {
        response = "The smallest insect in the world is the fairyfly.";
    } else if (lowerCaseInput.contains("what is the smallest animal in the world")) {
        response = "The smallest animal in the world is the tardigrade.";
    } else if (lowerCaseInput.contains("what is the smallest bird in North America")) {
        response = "The smallest bird in North America is the calliope hummingbird.";
    } else if (lowerCaseInput.contains("what is the smallest bird in South America")) {
        response = "The smallest bird in South America is the buff-fronted hummingbird.";
    } else if (lowerCaseInput.contains("what is the smallest bird in Australia")) {
        response = "The smallest bird in Australia is the weebill.";
    } else if (lowerCaseInput.contains("what is the smallest bird in Africa")) {
        response = "The smallest bird in Africa is the African pygmy kingfisher.";
    } else if (lowerCaseInput.contains("what is the smallest bird in Asia")) {
        response = "The smallest bird in Asia is the bee hummingbird.";
    } else if (lowerCaseInput.contains("what is the smallest bird in Europe")) {
        response = "The smallest bird in Europe is the goldcrest.";
    } else if (lowerCaseInput.contains("what is the smallest bird in Antarctica")) {
        response = "There are no birds native to Antarctica.";
    } else if (lowerCaseInput.contains("what is the smallest bird in the world")) {
        response = "The smallest bird in the world is the bee hummingbird.";
    } else if (lowerCaseInput.contains("what is the fastest bird in the world")) {
        response = "The fastest bird in the world is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the fastest animal in the world")) {
        response = "The fastest animal in the world is the cheetah.";
    } else if (lowerCaseInput.contains("what is the fastest fish in the world")) {
        response = "The fastest fish in the world is the sailfish.";
    } else if (lowerCaseInput.contains("what is the fastest insect in the world")) {
        response = "The fastest insect in the world is the Australian tiger beetle.";
    } else if (lowerCaseInput.contains("what is the fastest land animal in the world")) {
        response = "The fastest land animal in the world is the cheetah.";
    } else if (lowerCaseInput.contains("what is the fastest bird in North America")) {
        response = "The fastest bird in North America is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the fastest bird in South America")) {
        response = "The fastest bird in South America is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the fastest bird in Australia")) {
        response = "The fastest bird in Australia is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the fastest bird in Africa")) {
        response = "The fastest bird in Africa is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the fastest bird in Asia")) {
        response = "The fastest bird in Asia is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the fastest bird in Europe")) {
        response = "The fastest bird in Europe is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the fastest bird in Antarctica")) {
        response = "There are no birds native to Antarctica.";
    } else if (lowerCaseInput.contains("what is the fastest animal in the ocean")) {
        response = "The fastest animal in the ocean is the sailfish.";
    } else if (lowerCaseInput.contains("what is the fastest animal in the air")) {
        response = "The fastest animal in the air is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the fastest animal in the world")) {
        response = "The fastest animal in the world is the peregrine falcon.";
    } else if (lowerCaseInput.contains("what is the slowest animal in the world")) {
        response = "The slowest animal in the world is the sloth.";
    } else if (lowerCaseInput.contains("what is the slowest bird in the world")) {
        response = "The slowest bird in the world is the American woodcock.";
    } else if (lowerCaseInput.contains("what is the slowest fish in the world")) {
        response = "The slowest fish in the world is the dwarf seahorse.";
    } else if (lowerCaseInput.contains("what is the slowest animal in North America")) {
        response = "The slowest animal in North America is the sloth.";
    } else if (lowerCaseInput.contains("what is the slowest animal in South America")) {
        response = "The slowest animal in South America is the sloth.";
    } else if (lowerCaseInput.contains("what is the slowest animal in Australia")) {
        response = "The slowest animal in Australia is the koala.";
    } else if (lowerCaseInput.contains("what is the slowest animal in Africa")) {
        response = "The slowest animal in Africa is the sloth.";
    } else if (lowerCaseInput.contains("what is the slowest animal in Asia")) {
        response = "The slowest animal in Asia is the sloth.";
    } else if (lowerCaseInput.contains("what is the slowest animal in Europe")) {
        response = "The slowest animal in Europe is the sloth.";
    } else if (lowerCaseInput.contains("what is the slowest animal in Antarctica")) {
        response = "There are no animals native to Antarctica.";
    } else if (lowerCaseInput.contains("what is the slowest animal in the ocean")) {
        response = "The slowest animal in the ocean is the sea horse.";
    } else if (lowerCaseInput.contains("what is the slowest animal in the air")) {
        response = "The slowest animal in the air is the American woodcock.";
    } else if (lowerCaseInput.contains("what is the slowest animal in the world")) {
        response = "The slowest animal in the world is the sloth.";
    } else {
        response = "I'm sorry, I didn't understand what you said.";
    }
    
    return response;
}
}
