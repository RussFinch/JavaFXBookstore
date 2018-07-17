package SqlQuery;

import Database.DbConnection;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class builds search Publisher query when
 * requested by Choice Box on delete Publisher
 * interface.
 * @author russellfincham
 * @version 0.1
 * @since 17-07-18
 */
public class SearchPublisher {
    /**
     * This method generates SQL following Publisher selection when
     * using choicebox on delete publisher interface.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to DeletePublisherController.nameChoiceBoxSelection method
     * to populate interface with details corresponding to selection.
     * @param publisherDetail details required to generate choice box data
     * @throws FileNotFoundException if data file cannot be accessed by
     * DbCredentials.DbUser.
     * @return ArrayList String result of SQL transaction.
     */
    public static ArrayList<String[]> Name(String publisherDetail)
            throws FileNotFoundException {

        String sqlPubSearch = "SELECT * FROM publishers WHERE publisher_name = '"
                + publisherDetail + "';";

        ArrayList<String[]> publisher;
        publisher = new ArrayList<>(DbConnection.Manager(sqlPubSearch));

        return publisher;
    }
}