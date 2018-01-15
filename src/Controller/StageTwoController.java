package Controller;

import View.StageTwo;
import javafx.stage.Stage;

public class StageTwoController {

    public static void closeStage(Stage topicStage) {

        StageTwo.parent.setDisable(false);
        topicStage.close();

    }

}
