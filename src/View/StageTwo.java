package View;

import Controller.StageTwoController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

        Pane root = new Pane();
        Scene scene2 = new Scene(root, 1024, 768);
        topicStage.setTitle("This is another scene.");

        topicStage.setScene(scene2);
        topicStage.setOnCloseRequest((WindowEvent we) -> StageTwoController.closeStage(topicStage));
        topicStage.show();

    }



}