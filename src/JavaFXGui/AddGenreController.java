package JavaFXGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for AddBook.fxml.
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
    private void btnGenreAddAction(ActionEvent event) throws Exception {

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