package SqlQuery.Add;

import Database.DbConnection;
import Database.UpdatesConnection;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * This class builds add genre query from data
 * generated by add genre interface.
 * @author russellfincham
 * @version 0.1
 * @since 12-07-18
 */
public class AddGenre {
    /**
     * This method generates SQL For a genre addition.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to AddGenreController.btnGenreAddAction method for
     * the add genre Interface.
     * Data validity checking handled before execution of INSERT.
     * @param genreId ID of new genre to be added
     * @param genreName Name of new genre to be added
     * @throws FileNotFoundException if file cannot be accessed by
     * DbCredentials.DbUser().
     * @return String result of SQL transaction.
     */
    public static String Query(String genreId, String genreName)
                                    throws FileNotFoundException {

        String result;

        String sqlTestID = "SELECT 1 FROM genre WHERE genre_id = '"
                + genreId + "' LIMIT 1;";

        String sqlTestName = "SELECT 1 FROM genre WHERE genre_name = '"
                + genreName + "' LIMIT 1;";

        String sqlQuery = "INSERT INTO genre (genre_name, genre_id) "
                + "VALUES ('" + genreName + "', '" + genreId + "');";

        ArrayList<String[]> idTest = new ArrayList<>(DbConnection.Manager(sqlTestID));
        ArrayList<String[]> nameTest = new ArrayList<>(DbConnection.Manager(sqlTestName));

        System.out.println(idTest.get(0)[0]);
        System.out.println(nameTest.get(0)[0]);

       if ((idTest.get(0)[0].equals("1")) || (nameTest.get(0)[0].equals("1"))) {
            result = "Name or ID already in use.";
        }
        else {
            result = UpdatesConnection.queryDatabase(sqlQuery);
        }
        return result;
    }
}