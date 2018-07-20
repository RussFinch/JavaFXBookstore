package Main;


import java.io.FileNotFoundException;
import Database.DbCredentials;
/**
 * This class manages the System login process.
 * @author russellfincham
 * @version 0.2
 * @since 05-07-18
 */
public class verifyCredentials {
    /**
     * This method matches manually input user credentials against those specified
     * in the file accessed by DbCredentials.DbUser.
     * @throws FileNotFoundException if DbCredentials.DbUser missing login file.
     * @param receivedUserID User ID entered by the user on Login screen
     * @param receivedPwd Password entered by user on Login screen
     * @return outcome of login process.
     */

    public static String run(String receivedUserID, String receivedPwd) throws FileNotFoundException {

        //call DbLogin interface to retrieve Database access credentials.
        String loginString[] = DbCredentials.DbUser();

        //Validate input credentials against database user credentials.
        //loginString[0] = userName, loginString[1] = password
        if (loginString[0].equals(null) || (loginString[0].equals(""))) {
            return "Dbase access User ID not configured";
        }
        else if (loginString[1].equals(null) || (loginString[1].equals(""))) {
            return "Dbase access user Password not configured";
        }
        else if (loginString[2].equals(null) || (loginString[2].equals(""))) {
            return "Dbase URL not configured";
        }
        else if (receivedUserID.equals(loginString[0]) && receivedPwd.equals(loginString[1])) {
            return "Signed In";
        }
        else {
            return "Incorrect User ID or Password..";
        }
    }
}
