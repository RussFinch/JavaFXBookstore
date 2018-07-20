package SqlQuery;

import Database.SettingRetrieve;

import java.io.FileNotFoundException;

/**
 * This class provides SQL for retrieving settings
 * held in the database.
 * @author russellfincham
 * @version 0.1
 * @since 17-07-18
 */
public class RetrieveSettings {

    /**
     * This method generates SQL for retrieving a setting value.
     * It generates the query which it then passes to the
     * database connection manager SettingRetrieve.querySettings.
     * @param settingName Name of the setting from which to retrieve the value
     * @return String result of SQL transaction settingValue.
     */
    public static String SettingsValue (String settingName) {

        String settingValue = null;

        String queryValue = "SELECT * FROM settings WHERE setting_name = '"
                + settingName + "';";

        try {
            settingValue = SettingRetrieve.querySettings(queryValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return settingValue;
    }

}
