package SqlQuery;

import Database.UpdateQuery;
import java.io.FileNotFoundException;

/**
 * This class builds update Publisher query from data
 * generated by update book interface.
 * @author russellfincham
 * @version 0.1
 * @since 16-07-18
 */

public class UpdatePublisher {
    /**
     * This method generates SQL For a publisher update.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to UpdatePublisherController.btnPublisherUpdAction method for
     * the Update publisher Interface.
     * Data validity checking handled before execution of UPDATE.
     * @throws FileNotFoundException if data file cannot be accessed by
     * @Param recordToUpdate
     * @Param pubId
     * @Param pubName
     * @Param pubPostcode
     * @Param pubAddress1
     * @Param pubAddress2
     * @Param pubAddress3
     * @Param pubTown
     * @return String result of SQL transaction.
     */
    public static String Query(String recordToUpdate, String pubId, String pubName,
                               String pubPostcode, String pubAddress1,
                               String pubAddress2, String pubAddress3,
                               String pubTown, String pubCounty)
            throws FileNotFoundException {

        String result;

        String sqlQuery = "UPDATE publishers SET "
                + "publisher_id = '" + pubId + "', "
                + "publisher_name = '" + pubName + "', "
                + "address_1 = '" + pubAddress1 + "', "
                + "address_2 = '" + pubAddress2 + "', "
                + "address_3 = '" + pubAddress3 + "', "
                + "address_town = '" + pubTown + "', "
                + "address_postcode = '" + pubPostcode + "', "
                + "address_county = '" + pubCounty + "' "
                + "WHERE publisher_id = '" + recordToUpdate + "';";

        result = UpdateQuery.queryDatabase(sqlQuery);

        return result;
    }
}