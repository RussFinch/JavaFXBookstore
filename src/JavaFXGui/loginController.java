package JavaFXGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {


    @FXML
    private TextField txtUserID;
    @FXML
    private Label lblMessage;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private void btnSignInAction(ActionEvent event) throws Exception {
        if (txtUserID.getText().equals("test") && txtPassword.getText().equals("test")) {
            lblMessage.setText("Username or Password is valid!");
/*            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("DateSelection.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Date Selection");
            stage.show();
*/
        } else {
            lblMessage.setText("Username or Password is invalid!");
        }
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
