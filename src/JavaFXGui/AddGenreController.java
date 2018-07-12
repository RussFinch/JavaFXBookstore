package JavaFXGui;

import Database.UpdateQuery;
import SqlQuery.AddGenre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    //Buttons
    @FXML
    private void btnGenreAddAction() throws Exception {

        String genreName = txtGenreNameAdd.getText();
        String genreID = txtGenreIDAdd.getText();

        if ((genreName.length() == 0) && (genreID.length() == 0)) {
            lblGenreAddIssues.setText("Both data entries filled");
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

    //Buttons
    @FXML
    private void btnGenreAddCancelAction(ActionEvent event) throws Exception {

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