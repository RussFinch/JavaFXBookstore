package Database;

import java.io.FileNotFoundException;
import java.sql.*;

/**
 * This class reads system settings held in the database.
 * @author russellfincham
 * @version 0.3
 * @since 17-07-18
 */

public class SettingsConnection {
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

        String loginString[] = DbCredentials.DbUser();

        //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
        try (
                Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);
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
