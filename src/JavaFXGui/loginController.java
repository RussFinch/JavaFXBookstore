package JavaFXGui;

import Main.verifyCredentials;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * controller class for Login.fxml.
 * @author russellfincham
 * @version 0.2
 * @since 04-07-18
 */
public class loginController implements Initializable {
    /**
     * Control for Login interface.  sets up user verification
     * process activated by button click or pressing Enter.
     * Enter key configured in fxml using defaultButton="true"
     * Then launches the main system window upon successful login.
     * Also provides access to DB user settings.
     */
    @FXML
    private TextField txtUserID;
    @FXML
    private Label lblMessage;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private void btnSignInAction(ActionEvent event) throws Exception {

        event.consume();
        String userID = txtUserID.getText();
        String password = txtPassword.getText();

        String loginState = verifyCredentials.run(userID, password);
        lblMessage.setText(loginState);

        if (loginState.equals("Signed In")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/JavaFXGui/Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("JavaFX BookStore..");
            stage.show();
        }
    }
    @FXML
    private void btnSettingsAction() throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("/JavaFXGui/Settings/DbAccess.fxml"));
        Stage setDbAccessStage = new Stage();
        Scene setDbAccessScene = new Scene(parent);
        setDbAccessStage.setScene(setDbAccessScene);
        setDbAccessStage.setTitle("JavaFX BookStore..  Setup Db Access");
        setDbAccessStage.show();
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
