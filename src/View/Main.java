package View;

import Controller.Controller;
import Models.DatabaseConnection;
import Models.Questions;
import Models.QuestionsService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;


public class Main extends Application {
    public static DatabaseConnection database;

    @Override
    public void start(Stage loginStage) throws Exception {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add("style.css");

        loginStage.setTitle("Hello World");
        loginStage.setScene(scene);
        loginStage.setOnCloseRequest((WindowEvent we) -> Controller.exitPrompt(we));
        loginStage.show();

        HBox topPane = new HBox(20);
        topPane.setPadding(new Insets(15, 12, 15, 12));
        topPane.setSpacing(10);
        Button topicButton = new Button("LOGIN");
        topicButton.getStyleClass().add("buttonOfWonder");
        topPane.getChildren().add(topicButton);
        Button regButton = new Button("REGISTER");
        regButton.getStyleClass().add("buttonOfWonder");
        topPane.getChildren().add(regButton);
        Button exitButton = new Button("X");
        exitButton.getStyleClass().add("buttonOfExit"); //test
        topPane.getChildren().add(exitButton);
        root.setTop(topPane);
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        VBox bottomPane = new VBox(0);
        root.setBottom(bottomPane);
        bottomPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);

        VBox centerPane = new VBox(20);

        //Defining the Name text field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setMinWidth(20);
        usernameField.setMaxWidth(300);
        centerPane.getChildren().add(usernameField);

        //Defining the Submit button
        Button submit = new Button("SUBMIT");
        submit.getStyleClass().add("buttonOfWonder");

        submit.setOnAction(ae -> Controller.createNewUser(usernameField.getText(), root));          // on click open new scene

        centerPane.getChildren().add(submit);

        centerPane.setPadding(new Insets(10, 10, 10, 10));      // Setting padding for centerPane where username textfield is

        root.setCenter(centerPane);
        //centerPane.getChildren().addAll(usernameLabel, usernameField);
        centerPane.setSpacing(10);
        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);

        loginStage.show();

    }


    public static void main(String[] args) {

        database = new DatabaseConnection("courseworkDatabase.db");
        ArrayList<Questions> testList = new ArrayList<>();
        QuestionsService.selectAll(testList, database);
        for (Questions c : testList) {
            System.out.println(c);
        }

        launch(args);

    }

}