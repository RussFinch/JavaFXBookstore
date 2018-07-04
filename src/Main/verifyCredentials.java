package Main;


import java.io.FileNotFoundException;

import Database.DbCredentials;

/**
 * This class manages the System login process.
 * @author russellfincham
 * @version 0.1
 * @since 04-07-18
 */

public class verifyCredentials {
    /**
     * This method matches manually input user credentials against those specified
     * in the file accessed by DbCredentials.DbUser.
     * @throws FileNotFoundException if DbCredentials.DbUser missing login file.
     * @return outcome of login process.
     */

    public static String run(String receivedUserID, String receivedPwd) throws FileNotFoundException {

        //call DbLogin interface to retrieve Database access credentials.
        String loginString = DbCredentials.DbUser();

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
