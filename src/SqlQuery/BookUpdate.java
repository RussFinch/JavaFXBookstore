package SqlQuery;

import Database.DbConnection;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manages update data generated by Book updates.
 * @author russellfincham
 * @version 0.1
 * @since 09-07-18
 */

public class BookUpdate {
    /**
     * This method generates SQL For a book update.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to btnUpdateBookAction method for the Home user Interface.
     * @throws FileNotFoundException if data file cannot be accessed by
     * @Param bookDescription
     * @Param bookGenreId
     * @Param bookPrice
     * @Param bookAuthorId
     * @Param bookPublisherId
     * @Param bookQty
     * @Param bookPubDate
     * @Param bookEdition
     * @Param authorId
     * @Param authorFName
     * @Param authorLName
     * @Param genreId
     * @Param genreName
     * @Param publisherId
     * @Param publisherName
     * @Param publisherPostcode
     * @Param publisherAddress1
     * @Param publisherAddress2
     * @Param publisherAddress3
     * @Param publisherTown
     * @Param publisherCounty
     * @return List Array of results returned to search book button action control.
     */
    public static List<String[]> Query(String bookId, String bookTitle,
                                       String bookDescription, String bookGenreId, String bookPrice, String bookAuthorId, String bookPublisherId, String bookQty,
                                       String bookPubDate, String bookEdition, String authorId, String authorFName, String authorLName, String genreId, String genreName,
                                       String publisherId, String publisherName, String publisherPostcode, String publisherAddress1, String publisherAddress2,
                                       String publisherAddress3, String publisherTown, String publisherCounty)
            throws FileNotFoundException {

        String sqlQuery = "UPDATE completeview "
                + "SET id = '" + bookId + "', "
                + "SET title = '" + bookTitle + "', "
                + "SET description = '" + bookDescription + "', "
                + "SET genre_id = '" + bookGenreId + "', "
                + "SET price = '" + bookPrice + "', "
                + "SET author_id = '" + bookAuthorId + "', "
                + "SET publisher_id = '" + bookPublisherId + "', "
                + "SET qty = '" + bookQty + "', "
                + "SET publish_date = '" + bookPubDate + "', "
                + "SET edition = '" + bookEdition + "', "
 //               + "SET author_id = '" + authorId + "', "
                + "SET author_firstname = '" + authorFName + "', "
                + "SET author_surname = '" + authorLName + "', "
                + "SET genre_id = '" + genreId + "', "
                + "SET genre_id = '" + genreName + "', "
                + "SET genre_id = '" + publisherId + "', "
                + "SET genre_id = '" + publisherName + "', "
                + "SET genre_id = '" + publisherPostcode + "', "
                + "SET genre_id = '" + publisherAddress1 + "', "
                + "SET genre_id = '" + publisherAddress2 + "', "
                + "SET genre_id = '" + publisherAddress3 + "', "
                + "SET genre_id = '" + publisherTown + "', "
                + "SET genre_id = '" + publisherCounty + "', "
                + "WHERE id = '" + bookId + "';";

 /*       String sqlQuery = "SELECT * FROM completeview WHERE id LIKE '%" + bookId + "%' "
                + "AND title LIKE '%" + bookTitle + "%' "
                + "AND description LIKE '%" + bookDescription + "%' "
                + "AND publish_date LIKE '%" + bookPubDate + "%' "
                + "AND edition LIKE '%" + bookEdition + "%' "
                + "AND author_id LIKE '%" + authorId + "%' "
                + "AND author_firstname LIKE '%" + authorFName + "%' "
                + "AND author_surname LIKE '%" + authorLName + "%' "
                + "AND genre_id LIKE '%" + genreId + "%' "
                + "AND genre_name LIKE '%" + genreName + "%' "
                + "AND publisher_id LIKE '%" + publisherId + "%' "
                + "AND publisher_name LIKE '%" + publisherName + "%';";
*/
        ArrayList<String[]> searchResult = new ArrayList<>(DbConnection.Manager(sqlQuery));

        return searchResult;
    }
}