package JavaFXGui;

import SqlQuery.ChoiceBoxes;
import SqlQuery.DeletePublisher;
import SqlQuery.PublisherSearch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * controller class for DeletePublisher.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 17-07-18
 */

public class DeletePublisherController implements Initializable {

    @FXML
    private TextField txtPubIdDel;
    @FXML
    private ChoiceBox<String> chbPubNameDel;
    @FXML
    private TextField txtPubPostcodeDel;
    @FXML
    private TextField txtPubAddress1Del;
    @FXML
    private TextField txtPubAddress2Del;
    @FXML
    private TextField txtPubAddress3Del;
    @FXML
    private TextField txtPubTownDel;
    @FXML
    private TextField txtPubCountyDel;
    @FXML
    private Label lblPubDelIssues;
    @FXML
    private Button btnCancel;

    //Buttons
    @FXML
    private void btnPubDelAction() throws Exception {

        //collect Book ID and Delete.
        String publisherId = txtPubIdDel.getText();

        String result = DeletePublisher.Query(publisherId);
        lblPubDelIssues.setText(result);
    }

    @FXML
    private void btnPubDelCancelAction() {

        Stage DelPubStage = (Stage) btnCancel.getScene().getWindow();
        DelPubStage.close();
    }

    @FXML
    private void nameChoiceBoxSelection() {

        String publisherName = chbPubNameDel.getValue();
        ArrayList<String[]> pubNameSelection = null;

        try {
            pubNameSelection = PublisherSearch.Name(publisherName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        txtPubIdDel.setText(pubNameSelection.get(0)[0]);
        txtPubAddress1Del.setText(pubNameSelection.get(0)[2]);
        txtPubAddress2Del.setText(pubNameSelection.get(0)[3]);
        txtPubAddress3Del.setText(pubNameSelection.get(0)[4]);
        txtPubTownDel.setText(pubNameSelection.get(0)[5]);
        txtPubCountyDel.setText(pubNameSelection.get(0)[6]);
        txtPubPostcodeDel.setText(pubNameSelection.get(0)[7]);
    }
        /**
         * Initializes the controller class.
         *
         * @param url
         * @param rb
         */
        @Override
        public void initialize (URL url, ResourceBundle rb){

            try {
                chbPubNameDel.getItems().setAll(ChoiceBoxes.PublisherNameChoice());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //Set default values for the GUI.
            int dataListNum = HomeController.listNum;
            ArrayList<String[]> data = HomeController.searchBookResult;

            txtPubIdDel.setText(data.get(dataListNum)[8]);
            chbPubNameDel.setValue(data.get(dataListNum)[13]);
            txtPubAddress1Del.setText(data.get(dataListNum)[14]);
            txtPubAddress2Del.setText(data.get(dataListNum)[15]);
            txtPubAddress3Del.setText(data.get(dataListNum)[16]);
            txtPubTownDel.setText(data.get(dataListNum)[17]);
            txtPubCountyDel.setText(data.get(dataListNum)[18]);
            txtPubPostcodeDel.setText(data.get(dataListNum)[19]);
        }
    }

