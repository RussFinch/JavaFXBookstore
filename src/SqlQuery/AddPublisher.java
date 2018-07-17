package SqlQuery;

import Database.DbConnection;
import Database.UpdatesConnection;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class builds add publisher query from data
 * generated by add publisher interface.
 * @author russellfincham
 * @version 0.1
 * @since 13-07-18
 */

public class AddPublisher {
    /**
     * This method generates SQL For a publisher addition.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to AddPublisherController.btnPubAddAction method for
     * the add Publisher Interface.
     * Data validity checking handled before execution of INSERT.
     * @throws FileNotFoundException if data file cannot be accessed by
     * @Param pubId
     * @Param pubName
     * @Param pubPostcode
     * @Param pubAddress1
     * @Param pubAddress2
     * @Param pubAddress3
     * @Param pubTown
     * @Param pubCounty
     * @return String result of SQL transaction.
     */
    public static String Query(String pubId, String pubName, String pubPostcode,
                               String pubAddress1, String pubAddress2, String pubAddress3,
                               String pubTown, String pubCounty)
            throws FileNotFoundException {

        String result;

        String sqlTestID = "SELECT 1 FROM publishers WHERE publisher_id = '"
                + pubId + "' LIMIT 1;";

        String sqlQuery = "INSERT INTO publishers VALUES "
                + "('" + pubId + "', '"
                + pubName + "', '"
                + pubAddress1 + "', '"
                + pubAddress2 + "', '"
                + pubAddress3 + "', '"
                + pubTown + "', '"
                + pubCounty + "', '"
                + pubPostcode + "');";

        ArrayList<String[]> pubIdTest = new ArrayList<>(DbConnection.Manager(sqlTestID));

        if (pubIdTest.get(0)[0].equals("1")) {
            result = "Publisher ID already in use.";
        }
        else {
            result = UpdatesConnection.queryDatabase(sqlQuery);
        }

        return result;
    }
}