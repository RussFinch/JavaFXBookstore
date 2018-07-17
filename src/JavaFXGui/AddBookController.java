package JavaFXGui;

import SqlQuery.AddBook;
import SqlQuery.ChoiceBoxes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * controller class for AddBook.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 13-07-18
 */

public class AddBookController implements Initializable {

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
    private ChoiceBox<String> cmbBookPublisherIdAdd;
    @FXML
    private ChoiceBox<String> cmbBookAuthorIdAdd;
    @FXML
    private ChoiceBox<String> cmdBookGenreIdAdd;
    @FXML
    private TextField txtBookQtyAdd;
    @FXML
    private Label lblBookAddIssues;
    @FXML
    private Button btnCancel;

    //Buttons
    @FXML
    private void btnBookAddAction() throws Exception {

        //collect and validate DatePicker values.
        LocalDate pubDate = txtBookPubDateAdd.getValue();

        //If no date send error message.
        if (pubDate == null) {
            lblBookAddIssues.setText("Published Date cannot be Null");
        }

        String bookId = txtBookIdAdd.getText();
        String bookTitle = txtBookTitleAdd.getText();
        String bookDescription = txtBookDescriptionAdd.getText();
        String bookPubDate = pubDate.toString();
        String bookEdition = txtBookEditionAdd.getText();
        String bookPrice = txtBookPriceAdd.getText();
        String bookPublisherId = cmbBookPublisherIdAdd.getSelectionModel().getSelectedItem();
        String bookAuthorId = cmbBookAuthorIdAdd.getSelectionModel().getSelectedItem();
        String bookGenreId = cmdBookGenreIdAdd.getSelectionModel().getSelectedItem();
        String bookQty = txtBookQtyAdd.getText();

        if ((bookId.length() == 0) || (bookId.length() >= 12)) {
            lblBookAddIssues.setText("Book ID must be between 1 and 11 characters");
        }
        else if (!bookId.matches("[0-9]{1,11}")) {
            lblBookAddIssues.setText("Book ID must be numeric..");
        }
        else if ((bookTitle.length() == 0) || (bookTitle.length() >= 51)) {
            lblBookAddIssues.setText("Book Title must be between 1 and 50 characters");
        }
        else if ((bookDescription.length() == 0) || (bookDescription.length() >= 256)) {
            lblBookAddIssues.setText("Book Description must be between 1 and 255 characters");
        }
        else if (bookPubDate == null) {
            lblBookAddIssues.setText("Published Date must not be empty");
        }
        else if ((bookEdition.length() == 0) || (bookEdition.length() >= 5)) {
            lblBookAddIssues.setText("Book Edition must be between 1 and 4 characters");
        }
        else if (!bookEdition.matches("[0-9]{1,4}")) {
            lblBookAddIssues.setText("Book Edition must be numeric..");
        }
        else if (bookPrice.length() == 0) {
            lblBookAddIssues.setText("Book Price must be completed..");
        }
        else if (!bookPrice.matches("[0-9]{1,4}+(\\.[0-9]{1,2})")) {
            lblBookAddIssues.setText("Book Price must be in currency format..");
        }
        else if (bookPublisherId.length() == 0) {
            lblBookAddIssues.setText("Publisher ID must not be blank.");
        }
        else if (bookAuthorId.length() == 0) {
            lblBookAddIssues.setText("Author ID must not be blank.");
        }
        else if (bookGenreId.length() == 0) {
            lblBookAddIssues.setText("Genre ID must not be blank.");
        }
        else if ((bookQty.length() == 0) || (bookQty.length() >= 12)){
            lblBookAddIssues.setText("Book Qty must be between 1 and 11 characters.");
        }
        else if (!bookQty.matches("[0-9]{1,11}")) {
            lblBookAddIssues.setText("Book Qty must be a number..");
        }
        else {
            String result = AddBook.Query(bookId, bookTitle, bookDescription, bookPubDate,
                                            bookEdition, bookPrice, bookPublisherId,
                                            bookAuthorId, bookGenreId, bookQty);
            lblBookAddIssues.setText(result);
        }
    }

    @FXML
    private void btnBookAddCancelAction() throws Exception {

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

        try {
            cmbBookPublisherIdAdd.getItems().setAll(ChoiceBoxes.PublisherIdChoice());
            cmbBookAuthorIdAdd.getItems().setAll(ChoiceBoxes.AuthorIdChoice());
            cmdBookGenreIdAdd.getItems().setAll(ChoiceBoxes.GenreIdChoice());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
