package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StageThree {
    public static Scene openSceneThree(){
        VBox root = new VBox (10);
        root.setPadding(new Insets(50));

        Scene scene = new Scene (root, 1024, 768);

        Button questionButton =new Button("Question 1");
        questionButton.getStyleClass().add("buttonOfWonder");
        root.getChildren().add(questionButton);

        return scene;
    }
}
