package JavaFXGui;


import java.io.FileNotFoundException;

import DbInterfaces.DbInterface;

/**
 * This class manages the user login process.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class verifyCredentials {
    /**
     * This method matches user input credentials against those specified
     * in the file accessed by DbInterface.DbLogin.
     * @throws FileNotFoundException if DbInterface.DbLogin missing login file.
     * @return state User Login state of loggedOut or loggedIn.
     */

    public static String run(String receivedUserID, String receivedPwd) throws FileNotFoundException {

        //call DbLogin interface to retrieve Database access credentials.
        String loginString = DbInterface.DbCredentials();

        String data[] = loginString.split(",");
        String userName = data[0];
        String password = data[1];

        //Validate input credentials against database user credentials.
        if (receivedUserID.equals(userName) && receivedPwd.equals(password)) {
            return "Signed In";
        }
        else {
            return "Incorrect User ID or Password..";
        }
    }
}
