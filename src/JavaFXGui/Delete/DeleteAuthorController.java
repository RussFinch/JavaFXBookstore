package JavaFXGui.Delete;

import JavaFXGui.HomeController;
import SqlQuery.*;
import SqlQuery.Delete.DeleteAuthor;
import SqlQuery.Search.SearchAuthor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * controller class for DeleteAuthor.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 17-07-18
 */
public class DeleteAuthorController implements Initializable {

    @FXML
    private ChoiceBox<String> chbAuthorIdDel;
    @FXML
    private TextField txtAuthorFNameDel;
    @FXML
    private TextField txtAuthorSNameDel;
    @FXML
    private Label lblAuthorDelIssues;
    @FXML
    private Button btnCancel;
    @FXML
    private void btnAuthorDelAction() throws Exception {

        //collect Book ID and Delete.
        String AuthorId = chbAuthorIdDel.getValue();

        String result = DeleteAuthor.Query(AuthorId);
        lblAuthorDelIssues.setText(result);
    }

    @FXML
    private void btnAuthorDelCancelAction() {

        Stage DelAuthorStage = (Stage) btnCancel.getScene().getWindow();
        DelAuthorStage.close();
    }

    @FXML
    private void IdChoiceBoxSelection() {

        String AuthorId = chbAuthorIdDel.getValue();
        ArrayList<String[]> authorIdSelection = null;

        try {
            authorIdSelection = SearchAuthor.ID(AuthorId);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        txtAuthorFNameDel.setText(authorIdSelection.get(0)[1]);
        txtAuthorSNameDel.setText(authorIdSelection.get(0)[2]);
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
            chbAuthorIdDel.getItems().setAll(ChoiceBoxes.AuthorIdChoice());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Set default values for the GUI.
        int dataListNum = HomeController.listNum;
        ArrayList<String[]> data = HomeController.searchBookResult;

        chbAuthorIdDel.setValue(data.get(dataListNum)[7]);
        txtAuthorFNameDel.setText(data.get(dataListNum)[0]);
        txtAuthorSNameDel.setText(data.get(dataListNum)[1]);
    }
}

