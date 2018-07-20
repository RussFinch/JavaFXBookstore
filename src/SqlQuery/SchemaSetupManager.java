package SqlQuery;

import Database.DbConnection;
import Database.UpdatesConnection;

import java.io.FileNotFoundException;

/**
 * This class creates the database schema when executed on system
 * first use.
 * @author russellfincham
 * @version 0.2
 * @since 19-07-18
 */

public class SchemaSetupManager {
    /**
     * This method creates the database Schema when the system is
     * first used. It is called from System settings once database
     * connection parameters have been configured.
     * Tables will be created in the system if they do not already exist.
     * If they do the table will be skipped.  A database view is also created
     * as its required for system searching.
     * @throws FileNotFoundException if data file cannot be accessed by
     * DbInterface.DbLogin.
     * @return String returned to calling code indicating setup has completed.
     */
    public static String dbSetupBooksTable() throws FileNotFoundException {

        String sqlCreateTableBooks = "CREATE TABLE IF NOT EXISTS books "
                + "(id INT,"
                + " title VARCHAR(50),"
                + " description VARCHAR(255),"
                + " genre_id VARCHAR(50),"
                + " price DECIMAL(4,2),"
                + " author_id VARCHAR(10),"
                + " publisher_id VARCHAR(10),"
                + " publish_date DATE,"
                + " edition TINYINT,"
                + " qty INT,"
                + " PRIMARY KEY (id),"
                + " FOREIGN KEY (author_id) REFERENCES "
                + " authors (author_id) ON UPDATE CASCADE,"
                + " FOREIGN KEY (genre_id) REFERENCES "
                + " genre (genre_id) ON UPDATE CASCADE,"
                + " FOREIGN KEY (publisher_id) REFERENCES "
                + "publishers (publisher_id) ON UPDATE CASCADE);";

        String result = UpdatesConnection.queryDatabase(sqlCreateTableBooks);

        return (result + ": Books Table Setup Complete\n\n");
    }

    public static String dbSetupPubsTable() throws FileNotFoundException {

        String sqlCreateTablePublishers = "CREATE TABLE IF NOT EXISTS publishers "
                + "(publisher_id VARCHAR(10),"
                + " publisher_name VARCHAR(50),"
                + " address_1 VARCHAR(20),"
                + " address_2 VARCHAR(20),"
                + " address_3 VARCHAR(20),"
                + " address_town VARCHAR(20),"
                + " address_county VARCHAR(20),"
                + " address_postcode VARCHAR(8),"
                + " PRIMARY KEY (publisher_id));";

        String result = UpdatesConnection.queryDatabase(sqlCreateTablePublishers);

        return (result + ": Publishers Table Setup Complete\n\n");
    }

    public static String dbSetupAuthTable() throws FileNotFoundException {

        String sqlCreateTableAuthors = "CREATE TABLE IF NOT EXISTS authors "
                + "(author_id VARCHAR(10),"
                + " author_firstname VARCHAR(50),"
                + " author_surname VARCHAR(20),"
                + " PRIMARY KEY (author_id));";

        String result = UpdatesConnection.queryDatabase(sqlCreateTableAuthors);

        return (result + ": Authors Table Setup Complete\n\n");
    }

    public static String dbSetupGenreTable() throws FileNotFoundException {

        String sqlCreateTableGenre = "CREATE TABLE IF NOT EXISTS genre "
                + "(genre_id VARCHAR(3),"
                + " genre_name VARCHAR(50),"
                + " PRIMARY KEY (genre_id));";

        String result = UpdatesConnection.queryDatabase(sqlCreateTableGenre);

        return (result + ": Genre Table Setup Complete\n\n");
    }

    public static String dbSetupUsersTable() throws FileNotFoundException {

        String sqlCreateTableUsers = "CREATE TABLE IF NOT EXISTS users "
                + "(user_id VARCHAR(255),"
                + " user_password VARCHAR(50) NOT NULL,"
                + " PRIMARY KEY (user_id));";

        String result = UpdatesConnection.queryDatabase(sqlCreateTableUsers);

        return (result + ": Users Table Setup Complete\n\n");
    }

    public static String dbSetupSettingsTable() throws FileNotFoundException {

        String sqlCreateTableSettings = "CREATE TABLE IF NOT EXISTS settings "
                + "(setting_name VARCHAR(255),"
                + " value VARCHAR(255),"
                + " PRIMARY KEY (setting_name));"
                + " INSERT INTO settings (setting_name, value)"
                + " VALUES"
                + " ('authorsUpload','unset'),"
                + " ('booksUpload','unset'),"
                + " ('genreUpload','unset'),"
                + " ('publishersUpload','unset'),"
                + " ('settingsUpload','unset'),"
                + " ('usersUpload','unset'),"
                + " ('dbLoginFile','unset'),";

        String result = UpdatesConnection.queryDatabase(sqlCreateTableSettings);

        return (result + ": Settings Table Setup Complete\n\n");
    }

    public static String dbSetupCompleteView() throws FileNotFoundException {

        String sqlCreateCompleteView = "CREATE VIEW completeview AS "
                + "SELECT authors.author_firstname, authors.author_surname, "
                + "books.id, books.title, books.description, books.genre_id, "
                + "books.price, books.author_id, books.publisher_id, books.publish_date, "
                + "books.edition, books.qty, "
                + "genre.genre_name, "
                + "publishers.publisher_name, publishers.address_1, publishers.address_2, "
                + "publishers.address_3, publishers.address_town, publishers.address_county, "
                + "publishers.address_postcode "
                + "FROM books LEFT JOIN authors USING (author_id) "
                + "RIGHT JOIN genre USING (genre_id) "
                + "RIGHT JOIN publishers USING (publisher_id);";

        String result = UpdatesConnection.queryDatabase(sqlCreateCompleteView);

        return (result + ": Database View Setup Complete\n\n");
    }
}
