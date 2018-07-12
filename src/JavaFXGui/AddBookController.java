package JavaFXGui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for AddGenre.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 12-07-18
 */

public class AddBookController implements Initializable {
    /**
     * Control for Add Book interface.  Allows
     * user to add another book.
     */

    @FXML
    private TextField txtBookIdAdd;
    @FXML
    private TextField txtBookTitleAdd;
    @FXML
    private TextArea txtBookDescriptionAdd;
    @FXML
    private DatePicker txtBookPubDateAdd;
    @FXML
    private TextField txtBookEditionAdd;
    @FXML
    private TextField txtBookPriceAdd;
    @FXML
    private TextField txtBookPublisherIdAdd;
    @FXML
    private TextField txtBookAuthorIdAdd;
    @FXML
    private TextField txtBookGenreIdAdd;
    @FXML
    private TextField txtBookQtyAdd;


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
