package SqlQuery;

import Database.DbConnection;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ComboBoxes {

    public static ArrayList<String> PublisherIdCombo() throws FileNotFoundException {

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

    public static ArrayList<String> PublisherNameCombo() throws FileNotFoundException {

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

    public static ArrayList<String> AuthorIdCombo() throws FileNotFoundException {

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

    public static ArrayList<String> GenreIdCombo() throws FileNotFoundException {

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

}
