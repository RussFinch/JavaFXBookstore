package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class manages the database and user credentials.
 * @author russellfincham
 * @version 0.2
 * @since 05-07-18
 */

public class DbCredentials {
    /**
     * This method collects database user ID, password and connection url
     * from file and is used by all methods that require this information.
     *
     * @return UserID, Password and Database url returned as String.
     * @throws FileNotFoundException if file cannot be accessed.
     */

    public final static String[] DbUser() throws FileNotFoundException {

        String[] data = new String[3];

        FileInputStream in = new FileInputStream("/Users/russellfincham/documents/temp/MySqlLogin.txt");
        Properties properties = new Properties();

        try {
            properties.load(in);
            in.close();

            String UserId = properties.getProperty("UserId");
            String Password = properties.getProperty("Password");
            String DbUrl = properties.getProperty("DbUrl");

            data[0] = UserId;
            data[1] = Password;
            data[2] = DbUrl;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}