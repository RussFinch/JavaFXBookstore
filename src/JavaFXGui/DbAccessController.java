package JavaFXGui;

import Database.DbCredentials;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for DbAccess.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 18-07-18
 */

public class DbAccessController implements Initializable {

    @FXML
    private TextField txtSetDbAccessUser;
    @FXML
    private PasswordField pwdSetDbAccessPwd;
    @FXML
    private TextField txtSetDbAccessUrl;
    @FXML
    private Label lblSetAccessResult;
    @FXML
    private Button btnCancel;

    //Buttons
    @FXML
    private void btnUpdateAction() {

        String userId = txtSetDbAccessUser.getText();
        String pwd = pwdSetDbAccessPwd.getText();
        String url = txtSetDbAccessUrl.getText();

            if (userId.length() != 0) {
                try {
                    String result = DbCredentials.DbAccessProperties("UserId", userId);
                    lblSetAccessResult.setText(result);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (pwd.length() != 0) {
                try {
                    String result = DbCredentials.DbAccessProperties("Password", pwd);
                    lblSetAccessResult.setText(result);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (url.length() != 0) {
                try {
                    String result = DbCredentials.DbAccessProperties("DbUrl", url);
                    lblSetAccessResult.setText(result);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    @FXML
    private void btnCancelAction() {

        Stage DbSchemaStage = (Stage) btnCancel.getScene().getWindow();
        DbSchemaStage.close();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}