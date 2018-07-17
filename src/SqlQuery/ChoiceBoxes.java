package SqlQuery;

import Database.DbConnection;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class builds choice box data for
 * selection
 * @author russellfincham
 * @version 0.1
 * @since 16-07-18
 */

public class ChoiceBoxes {
    /**
     * This method generates SQL for displaying
     * selections for a Publisher ID Choice box.
     * @throws FileNotFoundException if data file cannot be accessed by
     * @return resultTable ArrayList string result of SQL transaction.
     */
    public static ArrayList<String> PublisherIdChoice() throws FileNotFoundException {

        ArrayList<String> resultTable = new ArrayList<>();

        String pubIdSql = "SELECT publisher_id FROM publishers;";
        ArrayList<String[]> pubIdSqlData = new ArrayList<>(DbConnection.Manager(pubIdSql));

        for (String[] row: pubIdSqlData) {
            for (String s : row) {
                resultTable.add(s);
            }
        }

        return resultTable;
    }
    /**
     * This method generates SQL for displaying
     * selections for a Publisher Name Choice box.
     * @throws FileNotFoundException if data file cannot be accessed by
     * @return resultTable ArrayList string result of SQL transaction.
     */
    public static ArrayList<String> PublisherNameChoice() throws FileNotFoundException {

        ArrayList<String> resultTable = new ArrayList<>();

        String pubNameSql = "SELECT publisher_name FROM publishers;";
        ArrayList<String[]> pubNameSqlData = new ArrayList<>(DbConnection.Manager(pubNameSql));

        for (String[] row: pubNameSqlData) {
            for (String s : row) {
                resultTable.add(s);
            }
        }

        return resultTable;
    }
    /**
     * This method generates SQL for displaying
     * selections for a Author ID Choice box.
     * @throws FileNotFoundException if data file cannot be accessed by
     * @return resultTable ArrayList string result of SQL transaction.
     */
    public static ArrayList<String> AuthorIdChoice() throws FileNotFoundException {

        ArrayList<String> resultTable = new ArrayList<>();

        String authIdSql = "SELECT author_id FROM authors;";
        ArrayList<String[]> authIdSqlData = new ArrayList<>(DbConnection.Manager(authIdSql));

        for (String[] row: authIdSqlData) {
            for (String s : row) {
                resultTable.add(s);
            }
        }

        return resultTable;
    }
    /**
     * This method generates SQL for displaying
     * selections for a Genre ID Choice box.
     * @throws FileNotFoundException if file cannot be accessed by
     * DbCredentials.DbUser().
     * @return resultTable ArrayList string result of SQL transaction.
     */
    public static ArrayList<String> GenreIdChoice() throws FileNotFoundException {

        ArrayList<String> resultTable = new ArrayList<>();

        String genreIdSql = "SELECT genre_id FROM genre;";
        ArrayList<String[]> genreIdSqlData = new ArrayList<>(DbConnection.Manager(genreIdSql));

        for (String[] row: genreIdSqlData) {
            for (String s : row) {
                resultTable.add(s);
            }
        }

        return resultTable;
    }
    /**
     * This method generates SQL for displaying
     * selections for a Genre Name Choice box.
     * @throws FileNotFoundException if data file cannot be accessed by
     * @return resultTable ArrayList string result of SQL transaction.
     */
    public static ArrayList<String> GenreNameChoice() throws FileNotFoundException {

        ArrayList<String> resultTable = new ArrayList<>();

        String genreNameSql = "SELECT genre_name FROM genre;";
        ArrayList<String[]> genreNameSqlData = new ArrayList<>(DbConnection.Manager(genreNameSql));

        for (String[] row: genreNameSqlData) {
            for (String s : row) {
                resultTable.add(s);
            }
        }

        return resultTable;
    }
}
