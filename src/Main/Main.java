package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * HomeController Class.  Launches Login interface.
 * @author russellfincham
 * @version 0.2
 * @since 04-07-18
 */

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/JavaFxGui/Login.fxml"));
        Scene login = new Scene(root);
        primaryStage.setScene(login);
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }
}
