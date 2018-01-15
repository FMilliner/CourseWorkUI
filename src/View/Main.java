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
        exitButton.getStyleClass().add("buttonOfExit");
        topPane.getChildren().add(exitButton);
        root.setTop(topPane);
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        VBox bottomPane = new VBox(0);
        root.setBottom(bottomPane);
        bottomPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);

        VBox centerPane = new VBox(20);
        Label usernameLabel = new Label("USERNAME");
        usernameLabel.getStyleClass().add("wonderLabel");
        usernameLabel.setPadding(new Insets(10));
        TextField usernameField = new TextField ();
        usernameField.setMaxWidth(160);

        Button loginEnter = new Button("CONFIRM");
        loginEnter.getStyleClass().add("buttonOfWonder");                           // Creating the button that is used to confirm login and move to stage 2
        centerPane.getChildren().add(loginEnter);

        loginEnter.setOnAction((ActionEvent ae) -> Controller.openNewStage(root));             // Enacting the action event that opens stage 2, connecting it to this button

        root.setCenter(centerPane);
        centerPane.getChildren().addAll(usernameLabel, usernameField);
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