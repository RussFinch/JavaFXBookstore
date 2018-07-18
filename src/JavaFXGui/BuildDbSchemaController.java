package JavaFXGui;

import SqlQuery.SchemaSetupManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for BuildDbSchema.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 18-07-18
 */

public class BuildDbSchemaController implements Initializable {

    @FXML
    private CheckBox chkSetBkTbl;
    @FXML
    private CheckBox chkSetPubTbl;
    @FXML
    private CheckBox chkSetAuthTbl;
    @FXML
    private CheckBox chkSetGenTbl;
    @FXML
    private CheckBox chkSetUsrTbl;
    @FXML
    private CheckBox chkSetSetTbl;
    @FXML
    private CheckBox chkSetDbView;
    @FXML
    private TextArea txtSetConfUpdates;
    @FXML
    private Button btnCancel;

    //Buttons
    @FXML
    private void btnSetupAction() throws Exception {

        if (chkSetBkTbl.isSelected()) {
            String setupResult = SchemaSetupManager.dbSetupBooksTable();
            txtSetConfUpdates.appendText(setupResult);
        }
        if (chkSetPubTbl.isSelected()) {
            String setupResult = SchemaSetupManager.dbSetupPubsTable();
            txtSetConfUpdates.appendText(setupResult);
        }
        if (chkSetAuthTbl.isSelected()) {
            String setupResult = SchemaSetupManager.dbSetupAuthTable();
            txtSetConfUpdates.appendText(setupResult);
        }
        if (chkSetGenTbl.isSelected()) {
            String setupResult = SchemaSetupManager.dbSetupGenreTable();
            txtSetConfUpdates.appendText(setupResult);
        }
        if (chkSetUsrTbl.isSelected()) {
            String setupResult = SchemaSetupManager.dbSetupUsersTable();
            txtSetConfUpdates.appendText(setupResult);
        }
        if (chkSetSetTbl.isSelected()) {
            String setupResult = SchemaSetupManager.dbSetupSettingsTable();
            txtSetConfUpdates.appendText(setupResult);
        }
        if (chkSetDbView.isSelected()) {
            String setupResult = SchemaSetupManager.dbSetupCompleteView();
            txtSetConfUpdates.appendText(setupResult);
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