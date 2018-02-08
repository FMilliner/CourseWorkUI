package View;

import Models.DatabaseConnection;
import Models.Questions;
import Models.QuestionsService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class StageThree {
    public static Scene openSceneThree(){
        VBox root = new VBox (10);
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.TOP_CENTER);
        Scene scene3 = new Scene (root, 1024, 768);



        ArrayList<Questions> testList = new ArrayList<>();
        QuestionsService.selectAll(testList, Main.database);

        int k = 1;                                                      //question number counter

        for (Questions c : testList) {
            scene3.getStylesheets().add("style.css");                   //move this out the for loop if it doesn't work
            Button questionButton =new Button("Question"+k);
            questionButton.getStyleClass().add("buttonOfWonder");
            root.getChildren().add(questionButton);
            k++;

            for (Questions l: testList){
                Label questionLabel = new Label(l.getQuestion());
                root.getChildren().add(questionLabel);
            }

            //root.getChildren().clear();                                 //clear the scene before filling it again with the new question
            System.out.println(c);
        }

        return scene3;
    }
}
