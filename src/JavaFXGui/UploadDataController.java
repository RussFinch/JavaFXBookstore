package JavaFXGui;

import Database.UploadData;
import SqlQuery.RetrieveSettings;
import SqlQuery.SetSettings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for UploadData.fxml.
 * @author russellfincham
 * @version 0.1
 * @since 18-07-18
 */

public class UploadDataController implements Initializable {

    @FXML
    private TextField txtUploadBookFile;
    @FXML
    private TextField txtUploadAuthFile;
    @FXML
    private TextField txtUploadPubsFile;
    @FXML
    private TextField txtUploadGenreFile;
    @FXML
    private TextField txtUploadUsersFile;
    @FXML
    private TextField txtUploadSettingsFile;
    @FXML
    private TextArea txaUploadFileNotes;
    @FXML
    private Button btnCancel;

    @FXML
    private void btnBooksFileAction() {

        FileChooser books = new FileChooser();
        books.setTitle("Open Book Upload File");
        File file = books.showOpenDialog(new Stage());

        txtUploadBookFile.setText(String.valueOf(file));
        txaUploadFileNotes.appendText("New Books File Selected:  " +
                String.valueOf(file) + "\n");
    }
    @FXML
    private void btnAuthorsFileAction() {

        FileChooser authors = new FileChooser();
        authors.setTitle("Open Authors Upload File");
        File file = authors.showOpenDialog(new Stage());

        txtUploadAuthFile.setText(String.valueOf(file));
        txaUploadFileNotes.appendText("New Authors File Selected:  " +
                String.valueOf(file) + "\n");
    }
    @FXML
    private void btnPublishersFileAction() {

        FileChooser publishers = new FileChooser();
        publishers.setTitle("Open Publishers Upload File");
        File file = publishers.showOpenDialog(new Stage());

        txtUploadPubsFile.setText(String.valueOf(file));
        txaUploadFileNotes.appendText("New Publishers File Selected:  " +
                String.valueOf(file) + "\n");
    }
    @FXML
    private void btnGenreFileAction() {

        FileChooser genre = new FileChooser();
        genre.setTitle("Open Genre Upload File");
        File file = genre.showOpenDialog(new Stage());

        txtUploadGenreFile.setText(String.valueOf(file));
        txaUploadFileNotes.appendText("New Genre File Selected:  " +
                String.valueOf(file) + "\n");
    }
    @FXML
    private void btnUsersFileAction() {

        FileChooser users = new FileChooser();
        users.setTitle("Open Users Upload File");
        File file = users.showOpenDialog(new Stage());

        txtUploadUsersFile.setText(String.valueOf(file));
        txaUploadFileNotes.appendText("New Users File Selected:  " +
                String.valueOf(file) + "\n");
    }
    @FXML
    private void btnSettingsFileAction() {

        FileChooser settings = new FileChooser();
        settings.setTitle("Open Settings Upload File");
        File file = settings.showOpenDialog(new Stage());

        txtUploadSettingsFile.setText(String.valueOf(file));
        txaUploadFileNotes.appendText("New Settings File Selected:  " +
                String.valueOf(file) + "\n");
    }
    @FXML
    private void btnBooksApplyAction() {

        String bookFile = txtUploadBookFile.getText();
        SetSettings.Setting("booksUpload", bookFile);
        txaUploadFileNotes.appendText("New Books File Applied:  " + bookFile + "\n");
    }
    @FXML
    private void btnAuthorsApplyAction() {

        String authorFile = txtUploadAuthFile.getText();
        SetSettings.Setting("authorsUpload", authorFile);
        txaUploadFileNotes.appendText("New Authors File Applied:  " + authorFile +"\n");
    }
    @FXML
    private void btnPublishersApplyAction() {

        String publisherFile = txtUploadPubsFile.getText();
        SetSettings.Setting("publishersUpload", publisherFile);
        txaUploadFileNotes.appendText("New Publishers File Applied:  " + publisherFile + "\n");
    }
    @FXML
    private void btnGenreApplyAction() {

        String genreFile = txtUploadGenreFile.getText();
        SetSettings.Setting("genreUpload", genreFile);
        txaUploadFileNotes.appendText("New Genre File Applied:  "  + genreFile + "\n");
    }
    @FXML
    private void btnUsersApplyAction() {

        String usersFile = txtUploadUsersFile.getText();
        SetSettings.Setting("usersUpload", usersFile);
        txaUploadFileNotes.appendText("New Users File Applied:  " + usersFile + "\n");
    }
    @FXML
    private void btnSettingsApplyAction() {

        String settingsFile = txtUploadSettingsFile.getText();
        SetSettings.Setting("settingsUpload", settingsFile);
        txaUploadFileNotes.appendText("New Settings File Applied:  " + settingsFile + "\n");
    }

    @FXML
    private void mitmUploadBooksAction() throws Exception {

        String booksFile = txtUploadBookFile.getText();
        String result = UploadData.booksDataUpload(booksFile);
        txaUploadFileNotes.appendText("Books Upload Started:\n\n" + result + "\n\n");
    }
    @FXML
    private void mitmUploadAuthorsAction() throws Exception {

        String authorsFile = txtUploadAuthFile.getText();
        String result = UploadData.authorsDataUpload(authorsFile);
        txaUploadFileNotes.appendText("Authors Upload Started:\n\n" + result + "\n\n");
    }
    @FXML
    private void mitmUploadPublishersAction() throws Exception {

        String publishersFile = txtUploadPubsFile.getText();
        String result = UploadData.publishersDataUpload(publishersFile);
        txaUploadFileNotes.appendText("Publishers Upload Started:\n\n" + result + "\n\n");
    }
    @FXML
    private void mitmUploadGenreAction() throws Exception {

        String genreFile = txtUploadGenreFile.getText();
        String result = UploadData.genreDataUpload(genreFile);
        txaUploadFileNotes.appendText("Genre Upload Started:\n\n" + result + "\n\n");
    }
    @FXML
    private void mitmUploadUsersAction() throws Exception {

        String usersFile = txtUploadUsersFile.getText();
        String result = UploadData.userDataUpload(usersFile);
        txaUploadFileNotes.appendText("Users Upload Started:\n\n" + result + "\n\n");
    }
    @FXML
    private void mitmUploadSettingsAction() throws Exception {

        String settingsFile = txtUploadSettingsFile.getText();
        String result = UploadData.settingsDataUpload(settingsFile);
        txaUploadFileNotes.appendText("Settings Upload Started:\n\n" + result + "\n\n");
    }
    @FXML
    private void btnUploadCancelAction() {

        Stage addAuthorStage = (Stage) btnCancel.getScene().getWindow();
        addAuthorStage.close();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtUploadBookFile.setText(RetrieveSettings.SettingsValue("booksUpload"));
        txtUploadAuthFile.setText(RetrieveSettings.SettingsValue("authorsUpload"));
        txtUploadPubsFile.setText(RetrieveSettings.SettingsValue("publishersUpload"));
        txtUploadGenreFile.setText(RetrieveSettings.SettingsValue("genreUpload"));
        txtUploadUsersFile.setText(RetrieveSettings.SettingsValue("usersUpload"));
        txtUploadSettingsFile.setText(RetrieveSettings.SettingsValue("settingsUpload"));
    }
}