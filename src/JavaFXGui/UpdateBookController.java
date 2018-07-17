package JavaFXGui;

import SqlQuery.ComboBoxes;
import SqlQuery.UpdateBook;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * controller class for UpdateBook.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 13-07-18
 */

public class UpdateBookController implements Initializable {

    //record currently open in home search window.
    private static String recordToUpdate;

    @FXML
    private TextField txtBookIdUpd;
    @FXML
    private TextField txtBookTitleUpd;
    @FXML
    private TextArea txtBookDescriptionUpd;
    @FXML
    private DatePicker dateBookPubDateUpd;
    @FXML
    private TextField txtBookEditionUpd;
    @FXML
    private TextField txtBookPriceUpd;
    @FXML
    private ChoiceBox<String> cmbBookPublisherIdUpd;
    @FXML
    private ChoiceBox<String> cmbBookAuthorIdUpd;
    @FXML
    private ChoiceBox<String> cmdBookGenreIdUpd;
    @FXML
    private TextField txtBookQtyUpd;
    @FXML
    private Label lblBookUpdIssues;
    @FXML
    private Button btnCancel;

    //Buttons
    @FXML
    private void btnBookUpdAction() throws Exception {

        //collect and validate DatePicker values.
        LocalDate pubDate = dateBookPubDateUpd.getValue();

        //If no date send error message.
        if (pubDate == null) {
            lblBookUpdIssues.setText("Published Date cannot be Null");
        }

        String bookId = txtBookIdUpd.getText();
        String bookTitle = txtBookTitleUpd.getText();
        String bookDescription = txtBookDescriptionUpd.getText();
        String bookPubDate = pubDate.toString();
        String bookEdition = txtBookEditionUpd.getText();
        String bookPrice = txtBookPriceUpd.getText();
        String bookPublisherId = cmbBookPublisherIdUpd.getSelectionModel().getSelectedItem();
        String bookAuthorId = cmbBookAuthorIdUpd.getSelectionModel().getSelectedItem();
        String bookGenreId = cmdBookGenreIdUpd.getSelectionModel().getSelectedItem();
        String bookQty = txtBookQtyUpd.getText();

        if ((bookId.length() == 0) || (bookId.length() >= 12)) {
            lblBookUpdIssues.setText("Book ID must be between 1 and 11 characters");
        }
        else if (!bookId.matches("[0-9]{1,11}")) {
            lblBookUpdIssues.setText("Book ID must be numeric..");
        }
        else if ((bookTitle.length() == 0) || (bookTitle.length() >= 51)) {
            lblBookUpdIssues.setText("Book Title must be between 1 and 50 characters");
        }
        else if ((bookDescription.length() == 0) || (bookDescription.length() >= 256)) {
            lblBookUpdIssues.setText("Book Description must be between 1 and 255 characters");
        }
        else if (bookPubDate == null) {
            lblBookUpdIssues.setText("Published Date must not be empty");
        }
        else if ((bookEdition.length() == 0) || (bookEdition.length() >= 5)) {
            lblBookUpdIssues.setText("Book Edition must be between 1 and 4 characters");
        }
        else if (!bookEdition.matches("[0-9]{1,4}")) {
            lblBookUpdIssues.setText("Book Edition must be numeric..");
        }
        else if (bookPrice.length() == 0) {
            lblBookUpdIssues.setText("Book Price must be completed..");
        }
        else if (!bookPrice.matches("[0-9]{1,4}+(\\.[0-9]{1,2})")) {
            lblBookUpdIssues.setText("Book Price must be in currency format..");
        }
        else if (bookPublisherId.length() == 0) {
            lblBookUpdIssues.setText("Publisher ID must not be blank.");
        }
        else if (bookAuthorId.length() == 0) {
            lblBookUpdIssues.setText("Author ID must not be blank.");
        }
        else if (bookGenreId.length() == 0) {
            lblBookUpdIssues.setText("Genre ID must not be blank.");
        }
        else if ((bookQty.length() == 0) || (bookQty.length() >= 12)){
            lblBookUpdIssues.setText("Book Qty must be between 1 and 11 characters.");
        }
        else if (!bookQty.matches("[0-9]{1,11}")) {
            lblBookUpdIssues.setText("Book Qty must be a number..");
        }
        else {
            String result = UpdateBook.Query(recordToUpdate, bookId, bookTitle,
                    bookDescription, bookPubDate, bookEdition, bookPrice,
                    bookPublisherId, bookAuthorId, bookGenreId, bookQty);
            lblBookUpdIssues.setText(result);
        }

        recordToUpdate = bookId;
    }

    @FXML
    private void btnBookUpdCancelAction() {

        Stage updBookStage = (Stage) btnCancel.getScene().getWindow();
        updBookStage.close();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Set default values for the GUI.
        int dataListNum = HomeController.listNum;
        ArrayList<String[]> data = HomeController.searchBookResult;
        recordToUpdate = data.get(dataListNum)[2];

        String pubDateStr = data.get(dataListNum)[9];
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bookPubDate = LocalDate.parse(pubDateStr,dateFormatter);

        txtBookIdUpd.setText(data.get(dataListNum)[2]);
        txtBookTitleUpd.setText(data.get(dataListNum)[3]);
        txtBookDescriptionUpd.setText(data.get(dataListNum)[4]);
        cmdBookGenreIdUpd.setValue(data.get(dataListNum)[5]);
        txtBookPriceUpd.setText(data.get(dataListNum)[6]);
        cmbBookAuthorIdUpd.setValue(data.get(dataListNum)[7]);
        cmbBookPublisherIdUpd.setValue(data.get(dataListNum)[8]);
        dateBookPubDateUpd.setValue(bookPubDate);
        txtBookEditionUpd.setText(data.get(dataListNum)[10]);
        txtBookQtyUpd.setText(data.get(dataListNum)[11]);

        //Populate combo boxes.
        try {
            cmbBookPublisherIdUpd.getItems().setAll(ComboBoxes.PublisherIdCombo());
            cmbBookAuthorIdUpd.getItems().setAll(ComboBoxes.AuthorIdCombo());
            cmdBookGenreIdUpd.getItems().setAll(ComboBoxes.GenreIdCombo());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
