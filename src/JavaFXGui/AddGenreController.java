package JavaFXGui;

import SqlQuery.AddGenre;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for AddGenre.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 12-07-18
 */

public class AddGenreController implements Initializable {

    @FXML
    private TextField txtGenreIDAdd;
    @FXML
    private TextField txtGenreNameAdd;
    @FXML
    private Label lblGenreAddIssues;
    @FXML
    private Button btnCancel;


    //Buttons
    @FXML
    private void btnGenreAddAction() throws Exception {

        String genreName = txtGenreNameAdd.getText();
        String genreID = txtGenreIDAdd.getText();

        if ((genreName.length() == 0) || (genreID.length() == 0)) {
            lblGenreAddIssues.setText("Fill both data entries.");
        }
        else if (genreName.length() > 50) {
            lblGenreAddIssues.setText("Genre Name too long..");
        }
        else if (genreID.length() > 3) {
            lblGenreAddIssues.setText("Genre ID too long..");
        }
        else {
            String result = AddGenre.Query(genreID, genreName);
            lblGenreAddIssues.setText(result);
        }

    }

    @FXML
    private void btnGenreAddCancelAction() {

        Stage addGenreStage = (Stage) btnCancel.getScene().getWindow();
        addGenreStage.close();
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