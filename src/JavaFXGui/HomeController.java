package JavaFXGui;

import SqlQuery.AuthorSearch;
import SqlQuery.BookSearch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
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
    private TextField txtBookPubDateSearch;
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
    private TextField txtBookDescriptionResult;
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
        String bookId = txtBookIdSearch.getText();
        String bookTitle = txtBookTitleSearch.getText();
        String bookDescription = txtBookDescriptionSearch.getText();
        String bookPubDate = txtBookPubDateSearch.getText();
        String bookEdition = txtBookEditionSearch.getText();

        ArrayList<String[]> searchBookResult = new ArrayList<>(BookSearch.Query(bookId, bookTitle,
                                                    bookDescription, bookPubDate, bookEdition));

        txtBookIdResult.setText(searchBookResult.get(0)[0]);
        txtBookTitleResult.setText(searchBookResult.get(0)[1]);
        txtBookDescriptionResult.setText(searchBookResult.get(0)[2]);
        txtBookGenreIdResult.setText(searchBookResult.get(0)[3]);
        txtBookPriceResult.setText(searchBookResult.get(0)[4]);
        txtBookAuthorIdResult.setText(searchBookResult.get(0)[5]);
        txtBookPublisherIdResult.setText(searchBookResult.get(0)[6]);
        txtBookPubDateResult.setText(searchBookResult.get(0)[7]);
        txtBookEditionResult.setText(searchBookResult.get(0)[8]);
        txtBookQtyResult.setText(searchBookResult.get(0)[6]);

        // Output result
        for(String[] row: searchBookResult) {
            for (String s : row) {
                System.out.print(" " + s);

            }
            System.out.println();
        }
    }
    @FXML
    private void btnAuthorSearchAction(ActionEvent event) throws Exception {

        event.consume();
        String authorId = txtAuthorIDSearch.getText();
        String authorFName = txtAuthorFNameSearch.getText();
        String authorLName = txtAuthorLNameSearch.getText();

        ArrayList<String[]> searchResult = new ArrayList<>(AuthorSearch.Query(authorId, authorFName, authorLName));

        // print result
        for( String[] row: searchResult ) {
            for (String s : row) {
                System.out.print(" " + s);

            }
            System.out.println();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}