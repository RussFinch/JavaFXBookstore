package SqlQuery;

import Database.DbConnection;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class Collect details of first book in database when
 * system initialises.
 * @author russellfincham
 * @version 0.1
 * @since 18-07-18
 */

public class FirstBook {
    /**
     * This method generates SQL to find the first entry in the
     * "complete" database view.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to HomeController.Initialize method for the Home Interface.
     * @throws FileNotFoundException if data file cannot be accessed by
     * DbCredentials.DbUser.
     * @param bookId ID of book to be found
     * @param bookTitle Title of book to be found
     * @param bookDescription Description of book to be found
     * @param bookStartPubDate Start published date of book to be found
     * @param bookEndPubDate End published date of book to be found
     * @param bookEdition Edition of book to be found
     * @param authorId ID of author to be found
     * @param authorFName First name of book to be found
     * @param authorLName Surname of book to be found
     * @param genreId Genre Id of book to be found
     * @param genreName Genre Name of book to be found
     * @param publisherId Publisher Id of book to be found
     * @param publisherName Publisher Name of book to be found
     * @return List Array of results returned to search book button action control.
     */
    public static List<String[]> Query(String bookId, String bookTitle, String bookDescription,
                                       String bookStartPubDate, String bookEndPubDate,
                                       String bookEdition, String authorId,
                                       String authorFName, String authorLName, String genreId,
                                       String genreName, String publisherId, String publisherName)
            throws FileNotFoundException {

        String sqlQuery = "SELECT * FROM ebookstore.completeview WHERE id LIKE '%" + bookId + "%' "
                + "AND title LIKE '%" + bookTitle + "%' "
                + "AND description LIKE '%" + bookDescription + "%' "
                + "AND publish_date BETWEEN '" + bookStartPubDate + "' AND '"
                + bookEndPubDate + "' "
                + "AND edition LIKE '%" + bookEdition + "%' "
                + "AND author_id LIKE '%" + authorId + "%' "
                + "AND author_firstname LIKE '%" + authorFName + "%' "
                + "AND author_surname LIKE '%" + authorLName + "%' "
                + "AND genre_id LIKE '%" + genreId + "%' "
                + "AND genre_name LIKE '%" + genreName + "%' "
                + "AND publisher_id LIKE '%" + publisherId + "%' "
                + "AND publisher_name LIKE '%" + publisherName + "%' "
                + "LIMIT 1;";

        ArrayList<String[]> searchResult = new ArrayList<>(DbConnection.Manager(sqlQuery));

        return searchResult;
    }
}