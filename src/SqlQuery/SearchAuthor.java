package SqlQuery;

import Database.DbConnection;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class builds search Author query when
 * requested by Choice Box on delete Author
 * interface.
 * @author russellfincham
 * @version 0.1
 * @since 17-07-18
 */
public class SearchAuthor {
    /**
     * This method generates SQL following Author selection when
     * using choicebox on delete Author interface.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to DeleteAuthorController.nameChoiceBoxSelection method
     * to populate interface with details corresponding to selection.
     * @Param authorDetail
     * @return ArrayList<String[]> result of SQL transaction.
     */
    public static ArrayList<String[]> ID(String authorDetail)
            throws FileNotFoundException {

        String sqlAuthorSearch = "SELECT * FROM authors WHERE author_id = '"
                + authorDetail + "';";

        ArrayList<String[]> author;
        author = new ArrayList<>(DbConnection.Manager(sqlAuthorSearch));

        return author;
    }
}