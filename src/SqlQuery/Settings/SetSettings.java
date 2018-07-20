package SqlQuery.Settings;

import Database.UpdatesConnection;
import java.io.FileNotFoundException;
/**
 * This class provides SQL for updating settings
 * held in the database.
 * @author russellfincham
 * @version 0.1
 * @since 18-07-18
 */
public class SetSettings {
    /**
    * This method generates SQL for updating a setting.
    * It generates the query which it then passes to the
    * database connection manager SettingRetrieve.querySettings.
    * @param settingName Name of the setting to be updated
    * @param value new value for the setting to be updated
    */
    public static void Setting (String settingName, String value) {

        String queryValue = "UPDATE settings SET value = '"
                + value + "' WHERE setting_name = '" + settingName + "';";

        try {
            UpdatesConnection.queryDatabase(queryValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
