package Database;

import java.io.FileNotFoundException;
import java.sql.*;

/**
 * This class reads system settings held in the database.
 * @author russellfincham
 * @version 0.2
 * @since 04-07-18
 */

public class SettingsQuery {
    /**
     * This method is used for all queries that require the value of
     * a system setting to be returned.
     * @throws FileNotFoundException if file cannot be accessed by
     * DbCredentials.DbUser().
     * @param sqlQuery query to be presented to the database.
     * @return settingValue.
     */
    //public method used for settings retrieval
    public static String querySettings (String sqlQuery) throws FileNotFoundException {

        String settingValue = "";

        String loginString = DbCredentials.DbUser();

        String data[] = loginString.split(",");
        String userName = data[0];
        String password = data[1];
        String dbUrl = data[2];

        try (
                Connection conn = DriverManager.getConnection(dbUrl, userName, password);
                Statement stmt = conn.createStatement();

        ) {

            ResultSet rset = stmt.executeQuery(sqlQuery);

            while (rset.next()) {
                settingValue = rset.getString("value");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return settingValue;
    }
}
