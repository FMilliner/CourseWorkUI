package Controller;

import Models.User;
import Models.UserService;
import View.Main;
import View.StageTwo;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class Controller {

    public static void openNewStage(Pane parent) {
        StageTwo topicStage = new StageTwo(parent);
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

    public static void createNewUser(String username, Pane root) {

        User newUser = new User(0, username, 0);
        UserService.save(newUser, Main.database);

        System.out.println("User " + username + " added to database.");     //adding new user to database

        Controller.openNewStage(root);

    }


}
