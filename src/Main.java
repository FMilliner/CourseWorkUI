import Models.DatabaseConnection;
import Models.Questions;
import Models.QuestionsService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.ArrayList;
import java.util.Optional;


public class Main extends Application {
    public static DatabaseConnection database;

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add("style.css");

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent we) -> exitPrompt(we));
        stage.show();

        /*
        VBox leftPane = new VBox(20);
        Button leftButton1 = new Button("I am left.");
        leftPane.getChildren().add(leftButton1);
        Button leftButton2 = new Button("I am left again.");
        leftPane.getChildren().add(leftButton2);
        root.setLeft(leftPane);
        leftPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(leftPane, Pos.CENTER_LEFT);         // Code for the left and right VBoxes

        VBox rightPane = new VBox(20);
        Button rightButton1 = new Button("I am right.");
        rightPane.getChildren().add(rightButton1);
        Button rightButton2 = new Button("I am right again.");
        rightPane.getChildren().add(rightButton2);
        root.setRight(rightPane);
        rightPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(rightPane, Pos.CENTER_RIGHT);
        */

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

        Button loginEnter = new Button("CONFIRM")
        loginEnter.getStyleClass().add("buttonOfWonder");                           // Creating the button that is used to confirm login and move to stage 2
        centerPane.getChildren().add(loginEnter);

        loginEnter.setOnAction((ActionEvent ae) -> openNewStage(root));             // Enacting the action event that opens stage 2, connecting it to this button

        root.setCenter(centerPane);
        centerPane.getChildren().addAll(usernameLabel, usernameField);
        centerPane.setSpacing(10);
        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);

        stage.show();

    }

    public static void openNewStage(Pane parent) {
        StageTwo topicScreen = new StageTwo(parent);
    }
    public class StageTwo {

        static Pane parent;

        public StageTwo(Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);
            start(stage);

        }

        public void start(Stage stage) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("This is another scene.");
            stage.setScene(scene);
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

        }

        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }

    }

    public static void doSomething(){ //do something here

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


    public static void exitPrompt(WindowEvent we) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to exit?");

        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        } else {
            we.consume();
        }

    }
}