package SqlQuery;

import Database.DbConnection;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manages search data generated by Book searches.
 * @author russellfincham
 * @version 0.2
 * @since 05-07-18
 */

public class BookSearch {
    /**
     * This method generates SQL FOR a search of the books table.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to btnSearchBookAction method for the Home user Interface.
     * @throws FileNotFoundException if data file cannot be accessed by
     * DbCredentials.DbUser.
     * @param bookId
     * @param bookTitle
     * @param bookDescription
     * @param bookPubDate
     * @param bookEdition
     * @return List Array of results returned to search book button action control.
     */
    public static List<String[]> Query(String bookId, String bookTitle, String bookDescription,
                                       String bookPubDate, String bookEdition)
            throws FileNotFoundException {

        String sqlQuery = "SELECT * FROM books WHERE id LIKE '%" + bookId + "%' "
                + "AND title LIKE '%" + bookTitle + "%' "
                + "AND description LIKE '%" + bookDescription + "%' "
                + "AND publish_date LIKE '%" + bookPubDate + "%' "
                + "AND edition LIKE '%" + bookEdition + "%';";

        ArrayList<String[]> searchResult = new ArrayList<>(DbConnection.Manager(sqlQuery));

        return searchResult;
    }
}
