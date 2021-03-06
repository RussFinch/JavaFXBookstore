package SqlQuery.Update;

import Database.UpdatesConnection;
import java.io.FileNotFoundException;
/**
 * This class builds update book query from data
 * generated by update book interface.
 * @author russellfincham
 * @version 0.2
 * @since 17-07-18
 */
public class UpdateBook {
    /**
     * This method generates SQL For a book update.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to UpdateBookController.btnBookUpdAction method for
     * the Update Book Interface.
     * Data validity checking handled before execution of UPDATE.
     * @throws FileNotFoundException if data file cannot be accessed by
     * @param recordToUpdate Book ID of the record to update
     * @param bookId New ID for the book record that needs updating
     * @param bookTitle New title for the book
     * @param bookDescription new description for the book
     * @param bookPubDate New published date for the book
     * @param bookEdition New edition for the book
     * @param bookPrice New price for the book
     * @param bookPublisherId New publisher ID for the book
     * @param bookAuthorId New usthor ID for the book
     * @param bookGenreId New genre ID for the book
     * @param bookQty New quatity of the book
     * @return String result of SQL transaction.
     */
    public static String Query(String recordToUpdate, String bookId, String bookTitle,
                               String bookDescription, String bookPubDate,
                               String bookEdition, String bookPrice,
                               String bookPublisherId, String bookAuthorId,
                               String bookGenreId, String bookQty)
            throws FileNotFoundException {

        String result;

        String sqlQuery = "UPDATE books SET "
                + "id = '" + bookId + "', "
                + "title = '" + bookTitle + "', "
                + "description = '" + bookDescription + "', "
                + "genre_id = '" + bookGenreId + "', "
                + "price = '" + bookPrice + "', "
                + "author_id = '" + bookAuthorId + "', "
                + "publisher_id = '" + bookPublisherId + "', "
                + "publish_date = '" + bookPubDate + "', "
                + "edition = '" + bookEdition + "', "
                + "qty = '" + bookQty + "' "
                + "WHERE id = '" + recordToUpdate + "';";

        result = UpdatesConnection.queryDatabase(sqlQuery);

        return result;
    }
}