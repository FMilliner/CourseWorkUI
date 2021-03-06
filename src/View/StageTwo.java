package View;

import Controller.StageTwoController;
import Models.Topic;
import Models.TopicService;
import Models.User;
import Models.UserService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
        topicStage.setTitle("This is another scene.");

        topicStage.setScene(scene2);

        scene2.getStylesheets().add("style.css");

        HBox topPane = new HBox(20);
        topPane.setPadding(new Insets(15, 12, 15, 12));
        topPane.setSpacing(10);

        Button topicButton = new Button("TOPICS");
        topicButton.getStyleClass().add("selectedButton");
        topPane.getChildren().add(topicButton);

        Button statsButton = new Button("STATS");
        statsButton.getStyleClass().add("buttonOfWonder");
        topPane.getChildren().add(statsButton);

        Button searchButton = new Button("SEARCH");
        searchButton.getStyleClass().add("buttonOfWonder");
        topPane.getChildren().add(searchButton);

        searchButton.setOnAction((ae) -> {
            topicPane.getChildren().clear();
            VBox temp = new VBox (10);
            temp.setPadding(new Insets(50));
            temp.setAlignment(Pos.TOP_CENTER);
            Scene scene3 = new Scene (temp, 1024, 768);

            topicPane.setTop(temp);

            Button sButton = new Button("Search User");
            sButton.getStyleClass().add("buttonOfWonder");
            temp.getChildren().add(sButton);

            TextField sField = new TextField();
            sField.setPromptText("Enter player username");
            sField.setMinWidth(20);
            sField.setMaxWidth(300);
            temp.getChildren().add(sField);

            sButton.setOnAction((event)-> {
                ArrayList<User> testList = new ArrayList<>();
                UserService.selectAll(testList, Main.database);
                for(User l: testList){
                    if(l.getUserName().equals(sField.getText())){
                        Label playerLabel=new Label(l.getUserName());
                        playerLabel.getStyleClass().add("wonderLabel");
                        temp.getChildren().add(playerLabel);

                        Label userScore =new Label(""+l.getScore());
                        userScore.getStyleClass().add("wonderLabel");
                        temp.getChildren().add(userScore);

                    }
                }
            });
        });
        /*
        Button exitButton = new Button("X");
        exitButton.getStyleClass().add("buttonOfExit"); //test
        topPane.getChildren().add(exitButton);
        */
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        topicPane.setTop(topPane);

        GridPane gridPane1 = new GridPane();
        gridPane1.setHgap(10);
        gridPane1.setVgap(10);
        gridPane1.setPadding(new Insets(10));

        ArrayList<Topic> topics = new ArrayList<>();

        TopicService.selectAll(topics, Main.database);

        int t = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button exampleButton = new Button(topics.get(t).toString());
                exampleButton.setPrefSize(400, 400);
                exampleButton.getStyleClass().add("topicButtons");
                gridPane1.add(exampleButton, x, y);

                exampleButton.setOnAction(ae -> topicStage.setScene(StageThree.openSceneThree()));

                t++;
                if (t > topics.size()) break;
            }
            if (t > topics.size()) break;
        }
        topicPane.setCenter(gridPane1);



        topicStage.setOnCloseRequest((WindowEvent we) -> StageTwoController.closeStage(topicStage));
        topicStage.show();

    }



}