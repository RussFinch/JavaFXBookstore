package DbInterfaces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * This class manages connections to the database.
 * @author russellfincham
 * @version 0.1
 * @since 26-06-18
 */

public class DbInterface {
    /**
     * This method collects database user ID, password and connection url
     * from file and is used by all methods that require this information.
     * @throws FileNotFoundException if file cannot be accessed.
     * @return UserID, Password and Database url returned as String.
     */

    public final static String DbCredentials() throws FileNotFoundException {

        String UserId = "";
        String Password = "";
        String DbUrl = "";

        FileInputStream in = new FileInputStream("/Users/russellfincham/documents/temp/MySqlLogin.txt");
        Properties properties = new Properties();

        try {
            properties.load(in);
            in.close();

            UserId = properties.getProperty("UserId");
            Password = properties.getProperty("Password");
            DbUrl = properties.getProperty("DbUrl");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return (UserId + "," + Password + "," + DbUrl);
    }

    /**
     * This method is used for all queries that require only a modification
     * of data within the database and no data to be returned
     * @throws FileNotFoundException if file cannot be accessed by
     * DbInterface.DbLogin().
     * @param sqlQuery query to be presented to the database.
     * @return String "Executed" to indicate completion of method.
     */
    public static String queryDatabase(String sqlQuery) throws FileNotFoundException {

        String userName = "";
        String password = "";
        String dbUrl = "";

        String loginString = DbInterface.DbCredentials();

        String data[] = loginString.split(",");
        userName = data[0];
        password = data[1];
        dbUrl = data[2];

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

    /**
     * This method is used for all queries that require the value of
     * a system setting to be returned.
     * @throws FileNotFoundException if file cannot be accessed by
     * DbInterface.DbLogin().
     * @param sqlQuery query to be presented to the database.
     * @return settingValue.
     */
    //public method used for settings retrieval
    public static String querySettings (String sqlQuery) throws FileNotFoundException {

        String userName = "";
        String password = "";
        String dbUrl = "";
        String settingValue = "";

        String loginString = DbInterface.DbCredentials();

        String data[] = loginString.split(",");
        userName = data[0];
        password = data[1];
        dbUrl = data[2];

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
