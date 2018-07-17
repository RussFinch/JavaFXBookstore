package SqlQuery;

import Database.DbConnection;
import Database.UpdatesConnection;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class builds add book query from data
 * generated by add book interface.
 * @author russellfincham
 * @version 0.1
 * @since 13-07-18
 */

public class AddBook {
    /**
     * This method generates SQL For a book addition.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to AddBookController.btnBookAddAction method for
     * the add Book Interface.
     * Data validity checking handled before execution of INSERT.
     * @param bookId The ID of the book to be added
     * @param bookTitle The title of the book to be added
     * @param bookDescription description of the book to be added
     * @param bookPubDate published date of the book to be added
     * @param bookEdition edition of the book to be added
     * @param bookPrice price of the book to be added
     * @param bookPublisherId ID of the books publisher
     * @param bookAuthorId ID of the books author
     * @param bookGenreId ID of the books genre
     * @param bookQty Qty of this book
     * @throws FileNotFoundException if file cannot be accessed by
     * DbCredentials.DbUser().
     * @return String result of SQL transaction.
     */
    public static String Query(String bookId, String bookTitle, String bookDescription,
                               String bookPubDate, String bookEdition, String bookPrice,
                               String bookPublisherId, String bookAuthorId,
                               String bookGenreId, String bookQty)
            throws FileNotFoundException {

        String sqlTestID = "SELECT 1 FROM books WHERE id = '"
                + bookId + "' LIMIT 1;";

        String sqlQuery = "INSERT INTO books VALUES "
                + "('" + bookId + "', '"
                + bookTitle + "', '"
                + bookDescription + "', '"
                + bookGenreId + "', '"
                + bookPrice + "', '"
                + bookAuthorId + "', '"
                + bookPublisherId + "', '"
                + bookPubDate + "', '"
                + bookEdition + "', '"
                + bookQty + "');";

        ArrayList<String[]> bookIdTest = new ArrayList<>(DbConnection.Manager(sqlTestID));

        if (bookIdTest.get(0)[0].equals("1")) {
            return "Book ID already in use.";
        }
        else {
            return UpdatesConnection.queryDatabase(sqlQuery);
        }
    }
}
