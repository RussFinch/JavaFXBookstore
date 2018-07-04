package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class manages the database and user credentials.
 * @author russellfincham
 * @version 0.1
 * @since 04-07-18
 */

public class DbCredentials {
    /**
     * This method collects database user ID, password and connection url
     * from file and is used by all methods that require this information.
     *
     * @return UserID, Password and Database url returned as String.
     * @throws FileNotFoundException if file cannot be accessed.
     */

    public final static String DbUser() throws FileNotFoundException {

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
}