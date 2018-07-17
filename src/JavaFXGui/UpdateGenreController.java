package JavaFXGui;

import SqlQuery.UpdateGenre;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * controller class for UpdateGenre.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 16-07-18
 */

public class UpdateGenreController implements Initializable {

    private static String recordToUpdate;

    @FXML
    private TextField txtGenreIDUpd;
    @FXML
    private TextField txtGenreNameUpd;
    @FXML
    private Label lblGenreUpdIssues;
    @FXML
    private Button btnCancel;

    @FXML
    private void btnGenreUpdCancelAction() {

        Stage UpdGenreStage = (Stage) btnCancel.getScene().getWindow();
        UpdGenreStage.close();
    }

    @FXML
    private void btnGenreUpdAction() throws Exception {

        String genreId = txtGenreIDUpd.getText();
        String genreName = txtGenreNameUpd.getText();

        if ((genreName.length() == 0) || (genreId.length() == 0)) {
            lblGenreUpdIssues.setText("Fill both data entries.");
        }
        else if (genreName.length() > 50) {
            lblGenreUpdIssues.setText("Genre Name too long..");
        }
        else if (genreId.length() > 3) {
            lblGenreUpdIssues.setText("Genre ID too long..");
        }
        else {
            String result = UpdateGenre.Query(recordToUpdate, genreId, genreName);
            lblGenreUpdIssues.setText(result);
        }

        recordToUpdate = genreId;

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        int dataListNum = HomeController.listNum;
        ArrayList<String[]> data = HomeController.searchBookResult;
        recordToUpdate = data.get(dataListNum)[5];

        txtGenreIDUpd.setText(data.get(dataListNum)[5]);
        txtGenreNameUpd.setText(data.get(dataListNum)[12]);

    }
}