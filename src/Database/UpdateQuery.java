package Database;

import java.io.FileNotFoundException;
import java.sql.*;

/**
 * This class manages database updates.
 * @author russellfincham
 * @version 0.2
 * @since 04-07-18
 */

public class UpdateQuery {

    /**
     * This method is used for all queries that require an update
     * of data within the database and no data to be returned
     *
     * @param sqlQuery query to be presented to the database.
     * @return String "Executed" to indicate completion of method.
     * @throws FileNotFoundException if file cannot be accessed by
     * DbCredentials.DbUser().
     */
    public static String queryDatabase(String sqlQuery) throws FileNotFoundException {

        String loginString = DbCredentials.DbUser();
        String data[] = loginString.split(",");
        String userName = data[0];
        String password = data[1];
        String dbUrl = data[2];

        try (
                Connection conn = DriverManager.getConnection(dbUrl, userName, password);
                Statement stmt = conn.createStatement();
        ) {

            stmt.executeUpdate(sqlQuery);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return "Executed.";
    }
}
