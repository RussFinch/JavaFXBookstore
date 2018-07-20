package Database;

import java.io.FileNotFoundException;
import java.sql.*;
/**
 * This class manages database updates.
 * @author russellfincham
 * @version 0.3
 * @since 17-07-18
 */
public class UpdatesConnection {
    /**
     * This method is used for all queries that require an update
     * of data within the database and no data to be returned
     * @param sqlQuery query to be presented to the database.
     * @return String "Executed" to indicate completion of method.
     * @throws FileNotFoundException if file cannot be accessed by
     * DbCredentials.DbUser().
     */
    public static String queryDatabase(String sqlQuery) throws FileNotFoundException {

        String loginString[] = DbCredentials.DbUser();

        try (
                //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
                Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);
                Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(sqlQuery);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Executed.";
    }
}
