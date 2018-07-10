package JavaFXGui;

import SqlQuery.BookSearch;
import SqlQuery.BookUpdate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * controller class for Home.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 04-07-18
 */

public class HomeController implements Initializable {
    /**
     * Control for Home interface.  Allows system BookSearch,
     * Data Add, Update, Delete and System Settings
     */
    //Book BookSearch TextFields
    @FXML
    private TextField txtBookIdSearch;
    @FXML
    private TextField txtBookTitleSearch;
    @FXML
    private TextField txtBookDescriptionSearch;
    @FXML
    private DatePicker txtBookStartPubDateSearch;
    @FXML
    private DatePicker txtBookEndPubDateSearch;
    @FXML
    private TextField txtBookEditionSearch;

    //Author Search TextFields
    @FXML
    private TextField txtAuthorIDSearch;
    @FXML
    private TextField txtAuthorFNameSearch;
    @FXML
    private TextField txtAuthorLNameSearch;

    //Genre Search TextFields
    @FXML
    private TextField txtGenreIDSearch;
    @FXML
    private TextField txtGenreNameSearch;

    //Publisher Search TextFields
    @FXML
    private TextField txtPublisherIDSearch;
    @FXML
    private TextField txtPublisherNameSearch;

    //Book Results TextFields
    @FXML
    private TextField txtBookIdResult;
    @FXML
    private TextField txtBookTitleResult;
    @FXML
    private TextArea txtBookDescriptionResult;
    @FXML
    private TextField txtBookPubDateResult;
    @FXML
    private TextField txtBookEditionResult;
    @FXML
    private TextField txtBookPriceResult;
    @FXML
    private TextField txtBookPublisherIdResult;
    @FXML
    private TextField txtBookAuthorIdResult;
    @FXML
    private TextField txtBookGenreIdResult;
    @FXML
    private TextField txtBookQtyResult;

    //Author Results TextFields
    @FXML
    private TextField txtAuthorIDResult;
    @FXML
    private TextField txtAuthorFNameResult;
    @FXML
    private TextField txtAuthorLNameResult;

    //Genre Results TextFields
    @FXML
    private TextField txtGenreIDResult;
    @FXML
    private TextField txtGenreNameResult;

    //Publisher Results TextFields
    @FXML
    private TextField txtPublisherIdResult;
    @FXML
    private TextField txtPublisherNameResult;
    @FXML
    private TextField txtPublisherPostcodeResult;
    @FXML
    private TextField txtPublisherAddress1Result;
    @FXML
    private TextField txtPublisherAddress2Result;
    @FXML
    private TextField txtPublisherAddress3Result;
    @FXML
    private TextField txtPublisherTownResult;
    @FXML
    private TextField txtPublisherCountyResult;

    //Buttons
    @FXML
    private void btnBookSearchAction(ActionEvent event) throws Exception {

        event.consume();

        //convert DatePicker values to strings.
        LocalDate startDate = txtBookStartPubDateSearch.getValue();
        LocalDate endDate = txtBookEndPubDateSearch.getValue();
        String startPublishDate = startDate.toString();
        String endPublishDate = endDate.toString();

        //Retrieve data.
        String bookId = txtBookIdSearch.getText();
        String bookTitle = txtBookTitleSearch.getText();
        String bookDescription = txtBookDescriptionSearch.getText();
        String bookStartPubDate = startPublishDate;
        String bookEndPubDate = endPublishDate;
        String bookEdition = txtBookEditionSearch.getText();
        String authorId = txtAuthorIDSearch.getText();
        String authorFName = txtAuthorFNameSearch.getText();
        String authorLName = txtAuthorLNameSearch.getText();
        String genreId = txtGenreIDSearch.getText();
        String genreName = txtGenreNameSearch.getText();
        String publisherId = txtPublisherIDSearch.getText();
        String publisherName = txtPublisherNameSearch.getText();

        //Initiate results collection from database.
        ArrayList<String[]> searchBookResult = new ArrayList<>(BookSearch.Query(bookId, bookTitle,
                                                bookDescription, bookStartPubDate, bookEndPubDate,
                                                bookEdition, authorId, authorFName, authorLName,
                                                genreId, genreName, publisherId, publisherName));

        //output results to interface
        txtBookIdResult.setText(searchBookResult.get(0)[2]);
        txtBookTitleResult.setText(searchBookResult.get(0)[3]);
        txtBookDescriptionResult.setText(searchBookResult.get(0)[4]);
        txtBookGenreIdResult.setText(searchBookResult.get(0)[5]);
        txtBookPriceResult.setText(searchBookResult.get(0)[6]);
        txtBookAuthorIdResult.setText(searchBookResult.get(0)[7]);
        txtBookPublisherIdResult.setText(searchBookResult.get(0)[8]);
        txtBookPubDateResult.setText(searchBookResult.get(0)[9]);
        txtBookEditionResult.setText(searchBookResult.get(0)[10]);
        txtBookQtyResult.setText(searchBookResult.get(0)[11]);
        txtAuthorIDResult.setText(searchBookResult.get(0)[7]);
        txtAuthorFNameResult.setText(searchBookResult.get(0)[0]);
        txtAuthorLNameResult.setText(searchBookResult.get(0)[1]);
        txtGenreIDResult.setText(searchBookResult.get(0)[5]);
        txtGenreNameResult.setText(searchBookResult.get(0)[12]);
        txtPublisherIdResult.setText(searchBookResult.get(0)[8]);
        txtPublisherNameResult.setText(searchBookResult.get(0)[13]);
        txtPublisherPostcodeResult.setText(searchBookResult.get(0)[19]);
        txtPublisherAddress1Result.setText(searchBookResult.get(0)[14]);
        txtPublisherAddress2Result.setText(searchBookResult.get(0)[15]);
        txtPublisherAddress3Result.setText(searchBookResult.get(0)[16]);
        txtPublisherTownResult.setText(searchBookResult.get(0)[17]);
        txtPublisherCountyResult.setText(searchBookResult.get(0)[18]);
    }

    @FXML
    private void btnAddBookAction(ActionEvent event) throws Exception {

        event.consume();
        String bookId = txtBookIdResult.getText();
        String bookTitle = txtBookTitleResult.getText();
        String bookDescription = txtBookDescriptionResult.getText();
        String bookGenreId = txtBookGenreIdResult.getText();
        String bookPrice = txtBookPriceResult.getText();
        String bookAuthorId = txtBookAuthorIdResult.getText();
        String bookPublisherId = txtBookPublisherIdResult.getText();
        String bookPubDate = txtBookPubDateResult.getText();
        String bookEdition = txtBookEditionResult.getText();
        String bookQty = txtBookQtyResult.getText();
        String authorId = txtAuthorIDResult.getText();
        String authorFName = txtAuthorFNameResult.getText();
        String authorLName = txtAuthorLNameResult.getText();
        String genreId = txtGenreIDResult.getText();
        String genreName = txtGenreNameResult.getText();
        String publisherId = txtPublisherIdResult.getText();
        String publisherName = txtPublisherNameResult.getText();
        String publisherPostcode = txtPublisherPostcodeResult.getText();
        String publisherAddress1 = txtPublisherAddress1Result.getText();
        String publisherAddress2 = txtPublisherAddress2Result.getText();
        String publisherAddress3 = txtPublisherAddress3Result.getText();
        String publisherTown = txtPublisherTownResult.getText();
        String publisherCounty = txtPublisherCountyResult.getText();

        ArrayList<String[]> searchBookResult = new ArrayList<>(BookUpdate.Query(bookId, bookTitle,
                bookDescription, bookGenreId, bookPrice, bookAuthorId, bookPublisherId, bookQty,
                bookPubDate, bookEdition, authorId, authorFName, authorLName, genreId, genreName,
                publisherId, publisherName, publisherPostcode, publisherAddress1, publisherAddress2,
                publisherAddress3, publisherTown, publisherCounty));

        // Output result
        for(String[] row: searchBookResult) {
            for (String s : row) {
                System.out.print(" " + s);
            }
            System.out.println();
        }

        txtBookIdResult.setText(searchBookResult.get(0)[2]);
        txtBookTitleResult.setText(searchBookResult.get(0)[3]);
        txtBookDescriptionResult.setText(searchBookResult.get(0)[4]);
        txtBookGenreIdResult.setText(searchBookResult.get(0)[5]);
        txtBookPriceResult.setText(searchBookResult.get(0)[6]);
        txtBookAuthorIdResult.setText(searchBookResult.get(0)[7]);
        txtBookPublisherIdResult.setText(searchBookResult.get(0)[8]);
        txtBookPubDateResult.setText(searchBookResult.get(0)[9]);
        txtBookEditionResult.setText(searchBookResult.get(0)[10]);
        txtBookQtyResult.setText(searchBookResult.get(0)[11]);
        txtAuthorIDResult.setText(searchBookResult.get(0)[7]);
        txtAuthorFNameResult.setText(searchBookResult.get(0)[0]);
        txtAuthorLNameResult.setText(searchBookResult.get(0)[1]);
        txtGenreIDResult.setText(searchBookResult.get(0)[5]);
        txtGenreNameResult.setText(searchBookResult.get(0)[12]);
        txtPublisherIdResult.setText(searchBookResult.get(0)[8]);
        txtPublisherNameResult.setText(searchBookResult.get(0)[13]);
        txtPublisherPostcodeResult.setText(searchBookResult.get(0)[19]);
        txtPublisherAddress1Result.setText(searchBookResult.get(0)[14]);
        txtPublisherAddress2Result.setText(searchBookResult.get(0)[15]);
        txtPublisherAddress3Result.setText(searchBookResult.get(0)[16]);
        txtPublisherTownResult.setText(searchBookResult.get(0)[17]);
        txtPublisherCountyResult.setText(searchBookResult.get(0)[18]);

    }

    @FXML
    private void btnUpdateBookAction(ActionEvent event) throws Exception {


    }

    @FXML
    private void btnDeleteBookAction(ActionEvent event) throws Exception {


    }

    @FXML
    private void btnSettingsAction(ActionEvent event) throws Exception {


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}