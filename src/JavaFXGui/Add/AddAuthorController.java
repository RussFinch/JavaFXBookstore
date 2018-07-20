package JavaFXGui.Add;

import SqlQuery.Add.AddAuthor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * controller class for AddAuthor.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 12-07-18
 */
public class AddAuthorController implements Initializable {

    @FXML
    private TextField txtAuthorIDAdd;
    @FXML
    private TextField txtAuthorFNameAdd;
    @FXML
    private TextField txtAuthorSNameAdd;
    @FXML
    private Label lblAuthorAddIssues;
    @FXML
    private Button btnCancel;
    @FXML
    private void btnAuthorAddCancelAction() {

        Stage addAuthorStage = (Stage) btnCancel.getScene().getWindow();
        addAuthorStage.close();
    }
    @FXML
    private void btnAuthorAddAction() throws Exception {

        String authorId = txtAuthorIDAdd.getText();
        String authorFName = txtAuthorFNameAdd.getText();
        String authorSName = txtAuthorSNameAdd.getText();

        if ((authorId.length() == 0) || (authorFName.length() == 0)
                                    || (authorSName.length() == 0)) {
            lblAuthorAddIssues.setText("Fill all data entries.");
        }
        else if (authorId.length() > 10) {
            lblAuthorAddIssues.setText("Author ID too long..");
        }
        else if (authorFName.length() > 50) {
            lblAuthorAddIssues.setText("Author First Name too long..");
        }
        else if (authorFName.length() > 20) {
            lblAuthorAddIssues.setText("Author Last Name too long..");
        }
        else {
            String result = AddAuthor.Query(authorId, authorFName, authorSName);
            lblAuthorAddIssues.setText(result);
        }
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