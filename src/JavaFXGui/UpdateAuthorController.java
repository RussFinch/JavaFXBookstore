package JavaFXGui;

import SqlQuery.UpdateAuthor;
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
 * controller class for UpdateAuthor.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 16-07-18
 */

public class UpdateAuthorController implements Initializable {

    private static String recordToUpdate;

    @FXML
    private TextField txtAuthorIDUpd;
    @FXML
    private TextField txtAuthorFNameUpd;
    @FXML
    private TextField txtAuthorSNameUpd;
    @FXML
    private Label lblAuthorUpdIssues;
    @FXML
    private Button btnCancel;

    @FXML
    private void btnAuthorUpdCancelAction() {

        Stage UpdAuthorStage = (Stage) btnCancel.getScene().getWindow();
        UpdAuthorStage.close();
    }

    @FXML
    private void btnAuthorUpdAction() throws Exception {

        String authorId = txtAuthorIDUpd.getText();
        String authorFName = txtAuthorFNameUpd.getText();
        String authorSName = txtAuthorSNameUpd.getText();

        if ((authorId.length() == 0) || (authorFName.length() == 0)
                || (authorSName.length() == 0)) {
            lblAuthorUpdIssues.setText("Fill all data entries.");
        }
        else if (authorId.length() > 10) {
            lblAuthorUpdIssues.setText("Author ID too long..");
        }
        else if (authorFName.length() > 50) {
            lblAuthorUpdIssues.setText("Author First Name too long..");
        }
        else if (authorFName.length() > 20) {
            lblAuthorUpdIssues.setText("Author Last Name too long..");
        }
        else {
            String result = UpdateAuthor.Query(recordToUpdate, authorId, authorFName, authorSName);
            lblAuthorUpdIssues.setText(result);
        }

        recordToUpdate = authorId;

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        int dataListNum = HomeController.listNum;
        ArrayList<String[]> data = HomeController.searchBookResult;
        recordToUpdate = data.get(dataListNum)[7];

        txtAuthorIDUpd.setText(data.get(dataListNum)[7]);
        txtAuthorFNameUpd.setText(data.get(dataListNum)[0]);
        txtAuthorSNameUpd.setText(data.get(dataListNum)[1]);

    }
}