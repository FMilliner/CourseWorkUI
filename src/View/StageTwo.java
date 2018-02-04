package View;

import Controller.Controller;
import Controller.StageTwoController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StageTwo {

    public static Pane parent;

    public StageTwo(Pane theParent) {

        Stage topicStage = new Stage();
        parent = theParent;
        parent.setDisable(true);
        start(topicStage);

    }

    public void start(Stage topicStage) {

        BorderPane topicPane = new BorderPane();

        Scene scene2 = new Scene(topicPane, 1024, 768);

        scene2.getStylesheets().add("style.css");

        topicStage.setTitle("Scene2");
        topicStage.setScene(scene2);

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
        //topicRoot.setTop(topPane);
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        topicPane.getChildren().add(topPane);

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                Button exampleButton = new Button(Integer.toString(x) + ", " + Integer.toString(y));
                exampleButton.setPrefSize(100, 100);
                root.add(exampleButton, x, y);
            }
        }

        topicStage.setOnCloseRequest((WindowEvent we) -> StageTwoController.closeStage(topicStage));
    }



}

