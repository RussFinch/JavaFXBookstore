package JavaFXGui;

import SqlQuery.ChoiceBoxes;
import SqlQuery.DeleteGenre;
import SqlQuery.SearchGenre;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * controller class for DeleteGenre.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 17-07-18
 */

public class DeleteGenreController implements Initializable {

    @FXML
    private TextField txtGenreIdDel;
    @FXML
    private ChoiceBox<String> chbGenreNameDel;
    @FXML
    private Label lblGenreDelIssues;
    @FXML
    private Button btnCancel;

    //Buttons
    @FXML
    private void btnGenreDelAction() throws Exception {

        //collect Book ID and Delete.
        String genreId = txtGenreIdDel.getText();

        String result = DeleteGenre.Query(genreId);
        lblGenreDelIssues.setText(result);
    }

    @FXML
    private void btnGenreDelCancelAction() {

        Stage DelGenStage = (Stage) btnCancel.getScene().getWindow();
        DelGenStage.close();
    }

    @FXML
    private void nameChoiceBoxSelection() {

        String genreName = chbGenreNameDel.getValue();
        ArrayList<String[]> genreNameSelection = null;

        try {
            genreNameSelection = SearchGenre.Name(genreName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        txtGenreIdDel.setText(genreNameSelection.get(0)[0]);
    }
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize (URL url, ResourceBundle rb){

        try {
            chbGenreNameDel.getItems().setAll(ChoiceBoxes.GenreNameChoice());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Set default values for the GUI.
        int dataListNum = HomeController.listNum;
        ArrayList<String[]> data = HomeController.searchBookResult;

        txtGenreIdDel.setText(data.get(dataListNum)[5]);
        chbGenreNameDel.setValue(data.get(dataListNum)[12]);
    }
}

