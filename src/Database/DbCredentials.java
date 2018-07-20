package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class manages the database user credentials.
 * @author russellfincham
 * @version 0.3
 * @since 17-07-18
 */

public class DbCredentials {
    /**
     * This method collects database user ID, password and connection url
     * from file and is used by all methods that require this information.
     * Details collected from file using properties file type.
     * @return UserID, Password and Database url returned as String.
     * @throws FileNotFoundException if file cannot be accessed by
     * DbCredentials.DbUser().
     */

    public static String[] DbUser() throws FileNotFoundException {

        String[] data = new String[3];

        FileInputStream in = new FileInputStream("src/MySqlLogin.txt");
        Properties properties = new Properties();

        try {
            //using properties file to select correct "property"
            properties.load(in);
            in.close();

            String UserId = properties.getProperty("UserId").replace("\\", "");
            String Password = properties.getProperty("Password").replace("\\", "");;
            String DbUrl = properties.getProperty("DbUrl").replace("\\", "");;

            data[0] = UserId;
            data[1] = Password;
            data[2] = DbUrl;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * This method manages changes to the properties file that
     * holds DB access privileges and url.
     * @param newPropertyValue String indicating the setting to be changed.
     * @param value New value for the setting.
     * @return String returned to calling code indicating "Configuration Updated.".
     * @throws FileNotFoundException if data file cannot be accessed.
     */
    public static String DbAccessProperties(String newPropertyValue, String value) throws FileNotFoundException {

        FileInputStream in = new FileInputStream("src/MySqlLogin.txt");
        Properties properties = new Properties();
        String results = "Empty";

        if (newPropertyValue.equals("UserId")) {
            results = "DBase User ID has been Updated";
        }
        else if (newPropertyValue.equals("Password")) {
            results = "DBase User Password has been Updated";
        }
        else if (newPropertyValue.equals("DbUrl")) {
            results = "DBase URL has been Updated";
        }

        try {
            //Load properties from file into properties table
            properties.load(in);
            in.close();

            FileOutputStream out = new FileOutputStream("src/MySqlLogin.txt");

            //Set new values for system properties.
            properties.setProperty(newPropertyValue, value);
            properties.store(out, null);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}
