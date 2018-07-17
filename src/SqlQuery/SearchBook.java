package SqlQuery;

import Database.DbConnection;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manages search data generated by Book searches.
 * @author russellfincham
 * @version 0.3
 * @since 09-07-18
 */

public class SearchBook {
    /**
     * This method generates SQL For a search of the "complete" dbase view.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to btnSearchBookAction method for the Home user Interface.
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
                + "AND publisher_name LIKE '%" + publisherName + "%';";

        ArrayList<String[]> searchResult = new ArrayList<>(DbConnection.Manager(sqlQuery));

        return searchResult;
    }
}
