package JavaFXGui.Add;

import SqlQuery.Add.AddPublisher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * controller class for AddPublisher.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 13-07-18
 */
public class AddPublisherController implements Initializable {

    @FXML
    private TextField txtPubIdAdd;
    @FXML
    private TextField txtPubNameAdd;
    @FXML
    private TextField txtPubPostcodeAdd;
    @FXML
    private TextField txtPubAddress1Add;
    @FXML
    private TextField txtPubAddress2Add;
    @FXML
    private TextField txtPubAddress3Add;
    @FXML
    private TextField txtPubTownAdd;
    @FXML
    private TextField txtPubCountyAdd;
    @FXML
    private Label lblPubAddIssues;
    @FXML
    private Button btnCancel;
    @FXML
    private void btnPubAddAction() throws Exception {

        String pubId = txtPubIdAdd.getText();
        String pubName = txtPubNameAdd.getText();
        String pubPostcode = txtPubPostcodeAdd.getText();
        String pubAddress1 = txtPubAddress1Add.getText();
        String pubAddress2 = txtPubAddress2Add.getText();
        String pubAddress3 = txtPubAddress3Add.getText();
        String pubTown = txtPubTownAdd.getText();
        String pubCounty = txtPubCountyAdd.getText();

        if ((pubId.length() == 0) || (pubId.length() >= 11)) {
            lblPubAddIssues.setText("ID must be between 1 and 11 characters");
        }
        else if ((pubName.length() == 0) || (pubName.length() >= 51)) {
            lblPubAddIssues.setText("Name must be between 1 and 50 characters");
        }
        else if ((pubPostcode.length() == 0) || (pubPostcode.length() >= 9)) {
            lblPubAddIssues.setText("Postcode must be between 1 and 8 characters");
        }
        else if ((pubAddress1.length() == 0) || (pubAddress1.length() >= 21)) {
            lblPubAddIssues.setText("Address 1 must be between 1 and 20 characters");
        }
        else if  (pubAddress2.length() >= 21) {
            lblPubAddIssues.setText("Address 2 must be less than 20 characters");
        }
        else if (pubAddress3.length() >= 21) {
            lblPubAddIssues.setText("Address 3 must be less than 20 characters");
        }
        else if ((pubTown.length() == 0) || (pubTown.length() >= 21)) {
            lblPubAddIssues.setText("Town must be between 1 and 20 characters");
        }
        else if ((pubCounty.length() == 0) || (pubCounty.length() >= 21)) {
            lblPubAddIssues.setText("County must be between 1 and 20 characters");
        }
        else {
            String result = AddPublisher.Query(pubId, pubName, pubPostcode, pubAddress1,
                    pubAddress2, pubAddress3, pubTown, pubCounty);
            lblPubAddIssues.setText(result);
        }
    }

    @FXML
    private void btnPubAddCancelAction() {

        Stage addBookStage = (Stage) btnCancel.getScene().getWindow();
        addBookStage.close();
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