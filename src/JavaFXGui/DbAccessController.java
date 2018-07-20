package JavaFXGui;

import Database.DbCredentials;
import SqlQuery.SetSettings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for DbAccess.fxml.
 * @author russellfincham
 * @version 0.2
 * @since 19-07-18
 */

public class DbAccessController implements Initializable {

    @FXML
    private TextField txtSetDbAccessUser;
    @FXML
    private PasswordField pwdSetDbAccessPwd;
    @FXML
    private TextField txtSetDbAccessUrl;
    @FXML
    private TextField txtSetSqlLoginFile;
    @FXML
    private Label lblSetAccessResult;
    @FXML
    private Button btnCancel;

    //Buttons
    @FXML
    private void btnUpdateAction() {

        String accessFile = txtSetSqlLoginFile.getText();
        String userId = txtSetDbAccessUser.getText();
        String pwd = pwdSetDbAccessPwd.getText();
        String url = txtSetDbAccessUrl.getText();

        try {
            if (accessFile.length() != 0) {
                SetSettings.Setting("dbLoginFile", accessFile);
                lblSetAccessResult.setText("Db Login file location set");
            }
            if (userId.length() != 0) {
                    String result = DbCredentials.DbAccessProperties("UserId", userId);
                    lblSetAccessResult.setText(result);
            }
            if (pwd.length() != 0) {
                    String result = DbCredentials.DbAccessProperties("Password", pwd);
                    lblSetAccessResult.setText(result);
            }
            if (url.length() != 0) {
                String result = DbCredentials.DbAccessProperties("DbUrl", url);
                lblSetAccessResult.setText(result);
            }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
    }
    @FXML
    private void btnCancelAction() {

        Stage DbAccessStage = (Stage) btnCancel.getScene().getWindow();
        DbAccessStage.close();
    }
    @FXML
    private void btnSelectFileAction() {

        FileChooser SqlLoginFile = new FileChooser();
        SqlLoginFile.setTitle("Open Sql Login File");
        File file = SqlLoginFile.showOpenDialog(new Stage());
        txtSetSqlLoginFile.setText(String.valueOf(file));
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