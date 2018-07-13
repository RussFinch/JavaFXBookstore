package JavaFXGui;

import SqlQuery.BookSearch;
import SqlQuery.BookUpdate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * controller class for Home.fxml.
 * @author russellfincham
 * @version 0.2
 * @since 10-07-18
 */

public class HomeController implements Initializable {
    /**
     * Control for Home interface.  Allows for Book Search,
     * Data Add, Update, Delete and System Settings
     */

    //variables used for search and iterating search results.
    private static int listNum = 0;
    private static ArrayList<String[]> searchBookResult;

    @FXML
    private Label lblSearchResultCounter;

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

        listNum = 0;

        event.consume();

        //collect and validate DatePicker values.
        LocalDate startDate = txtBookStartPubDateSearch.getValue();
        LocalDate endDate = txtBookEndPubDateSearch.getValue();

        //If no date enter default values set as below.
        if (startDate == null) {
            startDate = LocalDate.of(0000, 01, 01);
        }
        if (endDate == null) {
            endDate = LocalDate.now();
        }

        //Retrieve data.
        String bookId = txtBookIdSearch.getText();
        String bookTitle = txtBookTitleSearch.getText();
        String bookDescription = txtBookDescriptionSearch.getText();
        String bookStartPubDate = startDate.toString();
        String bookEndPubDate = endDate.toString();
        String bookEdition = txtBookEditionSearch.getText();
        String authorId = txtAuthorIDSearch.getText();
        String authorFName = txtAuthorFNameSearch.getText();
        String authorLName = txtAuthorLNameSearch.getText();
        String genreId = txtGenreIDSearch.getText();
        String genreName = txtGenreNameSearch.getText();
        String publisherId = txtPublisherIDSearch.getText();
        String publisherName = txtPublisherNameSearch.getText();

        //Initiate results collection from database.
        searchBookResult = new ArrayList<>(BookSearch.Query(bookId, bookTitle,
                bookDescription, bookStartPubDate, bookEndPubDate,
                bookEdition, authorId, authorFName, authorLName,
                genreId, genreName, publisherId, publisherName));

/*        // Output result for testing
        for (String[] row: searchBookResult) {
            for (String s : row) {
                System.out.print(" " + s);
            }
            System.out.println();
        }
*/
        SearchDisplayResult(listNum, searchBookResult);
    }

    @FXML
    private void SearchDisplayResult (int listNum, ArrayList<String[]> searchBookResult) {

        int list = listNum;

        //output results to interface
        txtAuthorFNameResult.setText(searchBookResult.get(list)[0]);
        txtAuthorLNameResult.setText(searchBookResult.get(list)[1]);
        txtBookIdResult.setText(searchBookResult.get(list)[2]);
        txtBookTitleResult.setText(searchBookResult.get(list)[3]);
        txtBookDescriptionResult.setText(searchBookResult.get(list)[4]);
        txtBookGenreIdResult.setText(searchBookResult.get(list)[5]);
        txtGenreIDResult.setText(searchBookResult.get(list)[5]);
        txtBookPriceResult.setText(searchBookResult.get(list)[6]);
        txtBookAuthorIdResult.setText(searchBookResult.get(list)[7]);
        txtAuthorIDResult.setText(searchBookResult.get(list)[7]);
        txtBookPublisherIdResult.setText(searchBookResult.get(list)[8]);
        txtPublisherIdResult.setText(searchBookResult.get(list)[8]);
        txtBookPubDateResult.setText(searchBookResult.get(list)[9]);
        txtBookEditionResult.setText(searchBookResult.get(list)[10]);
        txtBookQtyResult.setText(searchBookResult.get(list)[11]);
        txtGenreNameResult.setText(searchBookResult.get(list)[12]);
        txtPublisherNameResult.setText(searchBookResult.get(list)[13]);
        txtPublisherAddress1Result.setText(searchBookResult.get(list)[14]);
        txtPublisherAddress2Result.setText(searchBookResult.get(list)[15]);
        txtPublisherAddress3Result.setText(searchBookResult.get(list)[16]);
        txtPublisherTownResult.setText(searchBookResult.get(list)[17]);
        txtPublisherCountyResult.setText(searchBookResult.get(list)[18]);
        txtPublisherPostcodeResult.setText(searchBookResult.get(list)[19]);

        //Output record counters to label
        String numRecords = Integer.toString(searchBookResult.size() - 1);

        lblSearchResultCounter.setText((Integer.toString(listNum + 1)) + " of " + numRecords + " records.");
    }

    @FXML
    private void btnBookNextAction(ActionEvent event) throws Exception {

        event.consume();
        int listSize = searchBookResult.size();

        if (listNum < (listSize - 2)) {
            listNum = listNum + 1;
            SearchDisplayResult(listNum, searchBookResult);
        }
    }

    @FXML
    private void btnBookPrevAction(ActionEvent event) throws Exception {

        event.consume();
        if (listNum > 0) {
            listNum = listNum - 1;
            SearchDisplayResult(listNum, searchBookResult);
        }
    }

    @FXML
    private void btnBookLastAction(ActionEvent event) throws Exception {

        event.consume();
        listNum = searchBookResult.size() - 2;
        SearchDisplayResult(listNum, searchBookResult);
    }

    @FXML
    private void btnBookFirstAction(ActionEvent event) throws Exception {

        event.consume();
        listNum = 0;
        SearchDisplayResult(listNum, searchBookResult);
    }

    @FXML
    private void btnAddBookAction() throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/JavaFXGui/AddBook.fxml"));
        Stage addBookStage = new Stage();
        Scene addBookScene = new Scene(parent);
        addBookStage.setScene(addBookScene);
        addBookStage.setTitle("JavaFX BookStore..  Add Book");
        addBookStage.show();

    }

    @FXML
    private void btnAddAuthorAction() throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/JavaFXGui/AddAuthor.fxml"));
        Stage addAuthorStage = new Stage();
        Scene addAuthorScene = new Scene(parent);
        addAuthorStage.setScene(addAuthorScene);
        addAuthorStage.setTitle("JavaFX BookStore..  Add Author");
        addAuthorStage.show();

    }

    @FXML
    private void btnAddGenreAction(ActionEvent event) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/JavaFXGui/AddGenre.fxml"));
        Stage addGenreStage = new Stage();
        Scene addGenreScene = new Scene(parent);
        addGenreStage.setScene(addGenreScene);
        addGenreStage.setTitle("JavaFX BookStore..  Add Genre");
        addGenreStage.show();
    }

    @FXML
    private void btnAddPublisherAction(ActionEvent event) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/JavaFXGui/AddPublisher.fxml"));
        Stage addPublisherStage = new Stage();
        Scene addPublisherScene = new Scene(parent);
        addPublisherStage.setScene(addPublisherScene);
        addPublisherStage.setTitle("JavaFX BookStore..  Add Publisher");
        addPublisherStage.show();

    }

    @FXML
    private void btnUpBookAction() throws Exception {


    }

    @FXML
    private void btnUpAuthorAction() throws Exception {


    }

    @FXML
    private void btnUpGenreAction() throws Exception {


    }

    @FXML
    private void btnUpPubAction() throws Exception {


    }

    @FXML
    private void btnDelBookAction() throws Exception {


    }

    @FXML
    private void btnDelAuthorAction() throws Exception {


    }

    @FXML
    private void btnDelGenAction() throws Exception {


    }

    @FXML
    private void btnDelPubAction() throws Exception {


    }

    @FXML
    private void btnSetDbAccAction() throws Exception {


    }

    @FXML
    private void btnSetDbSchAction() throws Exception {


    }

    @FXML
    private void btnSetUpDataAction() throws Exception {


    }

    @FXML
    private void btnSetUsersAction() throws Exception {


    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


}