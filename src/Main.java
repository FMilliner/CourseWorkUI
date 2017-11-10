import Models.DatabaseConnection;
import Models.Questions;
import Models.QuestionsService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent we) -> exitPrompt(we));
        stage.show();

        VBox leftPane = new VBox(20);
        Button leftButton1 = new Button("I am left.");
        leftPane.getChildren().add(leftButton1);
        Button leftButton2 = new Button("I am left again.");
        leftPane.getChildren().add(leftButton2);
        root.setLeft(leftPane);
        leftPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(leftPane, Pos.CENTER_LEFT);

        VBox rightPane = new VBox(20);
        Button rightButton1 = new Button("I am right.");
        rightPane.getChildren().add(rightButton1);
        Button rightButton2 = new Button("I am right again.");
        rightPane.getChildren().add(rightButton2);
        root.setRight(rightPane);
        rightPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(rightPane, Pos.CENTER_RIGHT);

        HBox topPane = new HBox(20);
        Button topicButton = new Button("TOPIC");
        topPane.getChildren().add(topicButton);
        Button topButton2 = new Button("I am top again.");
        topPane.getChildren().add(topButton2);
        Button searchButton = new Button("SEARCH");
        topPane.getChildren().add(searchButton);
        root.setTop(topPane);
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        VBox bottomPane = new VBox(0);
        root.setBottom(bottomPane);
        bottomPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);

        VBox centerPane = new VBox(20);
        Button centerButton1 = new Button("I am centre.");
        centerPane.getChildren().add(centerButton1);
        Button centerButton2 = new Button("I am centre again.");
        centerPane.getChildren().add(centerButton2);
        root.setCenter(centerPane);
        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);

    }

    public static void doSomething(){ //do something here

    }

    public static void main(String[] args) {
        launch(args);
    }
    database = new DatabaseConnection("courseworkDatabase.db");
    ArrayList<Questions> testList = new ArrayList<>();
    QuestionsService.selectAll(testList, database);
    for(Questions c: testList){
        System.out.println(c);
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