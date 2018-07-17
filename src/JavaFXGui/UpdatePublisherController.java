package JavaFXGui;

import SqlQuery.AddPublisher;
import SqlQuery.UpdatePublisher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * controller class for UpdatePublisher.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 16-07-18
 */

public class UpdatePublisherController implements Initializable {

    private static String recordToUpdate;

    @FXML
    private TextField txtPubIdUpd;
    @FXML
    private TextField txtPubNameUpd;
    @FXML
    private TextField txtPubPostcodeUpd;
    @FXML
    private TextField txtPubAddress1Upd;
    @FXML
    private TextField txtPubAddress2Upd;
    @FXML
    private TextField txtPubAddress3Upd;
    @FXML
    private TextField txtPubTownUpd;
    @FXML
    private TextField txtPubCountyUpd;
    @FXML
    private Label lblPubUpdIssues;
    @FXML
    private Button btnCancel;

    @FXML
    private void btnPubUpdCancelAction() {

        Stage UpdPubStage = (Stage) btnCancel.getScene().getWindow();
        UpdPubStage.close();
    }

    @FXML
    private void btnPubUpdAction() throws Exception {

        String pubId = txtPubIdUpd.getText();
        String pubName = txtPubNameUpd.getText();
        String pubPostcode = txtPubPostcodeUpd.getText();
        String pubAddress1 = txtPubAddress1Upd.getText();
        String pubAddress2 = txtPubAddress2Upd.getText();
        String pubAddress3 = txtPubAddress3Upd.getText();
        String pubTown = txtPubTownUpd.getText();
        String pubCounty = txtPubCountyUpd.getText();

        if ((pubId.length() == 0) || (pubId.length() >= 11)) {
            lblPubUpdIssues.setText("ID must be between 1 and 11 characters");
        }
        else if ((pubName.length() == 0) || (pubName.length() >= 51)) {
            lblPubUpdIssues.setText("Name must be between 1 and 50 characters");
        }
        else if ((pubPostcode.length() == 0) || (pubPostcode.length() >= 9)) {
            lblPubUpdIssues.setText("Postcode must be between 1 and 8 characters");
        }
        else if ((pubAddress1.length() == 0) || (pubAddress1.length() >= 21)) {
            lblPubUpdIssues.setText("Address 1 must be between 1 and 20 characters");
        }
        else if  (pubAddress2.length() >= 21) {
            lblPubUpdIssues.setText("Address 2 must be less than 20 characters");
        }
        else if (pubAddress3.length() >= 21) {
            lblPubUpdIssues.setText("Address 3 must be less than 20 characters");
        }
        else if ((pubTown.length() == 0) || (pubTown.length() >= 21)) {
            lblPubUpdIssues.setText("Town must be between 1 and 20 characters");
        }
        else if ((pubCounty.length() == 0) || (pubCounty.length() >= 21)) {
            lblPubUpdIssues.setText("County must be between 1 and 20 characters");
        }
        else {
            String result = UpdatePublisher.Query(recordToUpdate, pubId, pubName, pubPostcode, pubAddress1,
                    pubAddress2, pubAddress3, pubTown, pubCounty);
            lblPubUpdIssues.setText(result);
        }

        recordToUpdate = pubId;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Set default values for the GUI.
        int dataListNum = HomeController.listNum;
        ArrayList<String[]> data = HomeController.searchBookResult;
        recordToUpdate = data.get(dataListNum)[8];

        txtPubIdUpd.setText(data.get(dataListNum)[8]);
        txtPubNameUpd.setText(data.get(dataListNum)[13]);
        txtPubAddress1Upd.setText(data.get(dataListNum)[14]);
        txtPubAddress2Upd.setText(data.get(dataListNum)[15]);
        txtPubAddress3Upd.setText(data.get(dataListNum)[16]);
        txtPubTownUpd.setText(data.get(dataListNum)[17]);
        txtPubCountyUpd.setText(data.get(dataListNum)[18]);
        txtPubPostcodeUpd.setText(data.get(dataListNum)[19]);

    }
}