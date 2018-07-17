package JavaFXGui;

import SqlQuery.DeleteBook;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * controller class for DeleteBook.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 16-07-18
 */

public class DeleteBookController implements Initializable {

    @FXML
    private TextField txtBookIdDel;
    @FXML
    private TextField txtBookTitleDel;
    @FXML
    private TextArea txtBookDescriptionDel;
    @FXML
    private TextField txtBookPubDateDel;
    @FXML
    private TextField txtBookEditionDel;
    @FXML
    private TextField txtBookPriceDel;
    @FXML
    private TextField txtBookPublisherIdDel;
    @FXML
    private TextField txtBookAuthorIdDel;
    @FXML
    private TextField txtBookGenreIdDel;
    @FXML
    private TextField txtBookQtyDel;
    @FXML
    private Label lblBookDelIssues;
    @FXML
    private Button btnCancel;

    //Buttons
    @FXML
    private void btnBookDelAction() throws Exception {

        //collect Book ID and Delete.
        String bookId = txtBookIdDel.getText();

        String result = DeleteBook.Query(bookId);
        lblBookDelIssues.setText(result);

    }


    @FXML
    private void btnBookDelCancelAction() {

        Stage DelBookStage = (Stage) btnCancel.getScene().getWindow();
        DelBookStage.close();
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

        txtBookIdDel.setText(data.get(dataListNum)[2]);
        txtBookTitleDel.setText(data.get(dataListNum)[3]);
        txtBookDescriptionDel.setText(data.get(dataListNum)[4]);
        txtBookGenreIdDel.setText(data.get(dataListNum)[5]);
        txtBookPriceDel.setText(data.get(dataListNum)[6]);
        txtBookAuthorIdDel.setText(data.get(dataListNum)[7]);
        txtBookPublisherIdDel.setText(data.get(dataListNum)[8]);
        txtBookPubDateDel.setText(data.get(dataListNum)[9]);
        txtBookEditionDel.setText(data.get(dataListNum)[10]);
        txtBookQtyDel.setText(data.get(dataListNum)[11]);

    }
}
