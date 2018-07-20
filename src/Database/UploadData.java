package Database;

import java.io.*;
import java.sql.*;
/**
 * This class manages data upload requests to the database.
 * It
 * @author russellfincham
 * @version 0.2
 * @since 19-07-18
 */
public class UploadData {
    /**
     * The method manages upload into the genre table in the database.
     * The database is logged into before data is read line by line from uploadFile,
     * split into separate attributes and inserted into the genre table using
     * a defined query.
     * @param uploadFile Location of file from which to upload
     * @throws FileNotFoundException if data file cannot be accessed.
     * @throws SQLException if DriverManager.getConnection unable to successfully
     * execute update.
     * @return String returned to calling code outlining data uploaded
     */
    public static String genreDataUpload(String uploadFile) throws FileNotFoundException, SQLException {

        //Genre table columns
        String genre_id;
        String genre_name;

        //result String
        String result = "";

        PreparedStatement ps = null;
        String[] loginString = DbCredentials.DbUser();

        try {
            //Data collection from file setup using location from database.
            BufferedReader reader = new BufferedReader(new FileReader(uploadFile));
            //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
            Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);

            //Extract data line by line, split and insert into database.
            String line;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                genre_id = data[0];
                genre_name = data[1];
                result = result.concat(genre_id + "\t" + genre_name + "\n");
                String sqlGenreUpload =
                        "INSERT INTO genre (genre_id, genre_name) values "
                                + "('" + genre_id + "', '" + genre_name + "');";
                ps = conn.prepareStatement(sqlGenreUpload);
                ps.executeUpdate();
            }
            result = result.concat("\nGenre Upload Finished..");

            reader.close();
            conn.close();
            ps.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * The method manages upload into the authors table in the database.
     * The database is logged into before data is read line by line from uploadFile,
     * split into separate attributes and inserted into the authors table using
     * a defined query.
     * @param uploadFile Location of file from which to upload
     * @throws FileNotFoundException if data file cannot be accessed.
     * @throws SQLException if DriverManager.getConnection unable to successfully
     * execute update.
     * @return String returned to calling code outlining data uploaded
     */
    public static String authorsDataUpload(String uploadFile) throws FileNotFoundException, SQLException {

        //Author table columns
        String author_id;
        String author_firstname;
        String author_surname;

        //result String
        String result = "";

        PreparedStatement ps = null;
        String[] loginString = DbCredentials.DbUser();

        try {
            //Data collection from file setup using location from database.
            BufferedReader reader = new BufferedReader(new FileReader(uploadFile));
            //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
            Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);

            //Extract data line by line, split and insert into database.
            String line;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                author_id = data[0];
                author_firstname = data[1];
                author_surname = data[2];
                result = result.concat(author_id + "\t" + author_firstname + "\t" + author_surname + "\n");
                String sqlAuthorUpload =
                        "INSERT INTO authors (author_id, author_firstname, author_surname) values "
                                + "('" + author_id + "', '" + author_firstname + "', '" + author_surname + "');";
                ps = conn.prepareStatement(sqlAuthorUpload);
                ps.executeUpdate();
            }
            result = result.concat("\nAuthors Upload Finished..");

            reader.close();
            conn.close();
            ps.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * The method manages upload into the books table in the database.
     * The database is logged into before data is read line by line from uploadFile,
     * split into separate attributes and inserted into the books table using
     * a defined query.
     * @param uploadFile Location of file from which to upload
     * @throws FileNotFoundException if data file cannot be accessed.
     * @throws SQLException if DriverManager.getConnection unable to successfully
     * execute update.
     * @return String returned to calling code outlining data uploaded
     */
    public static String booksDataUpload(String uploadFile) throws FileNotFoundException, SQLException {

        //Books table columns
        String id;
        String title;
        String description;
        String genre_id;
        String price;
        String author_id;
        String publisher_id;
        String publish_date;
        String edition;
        String qty;

        //result String
        String result = "";

        PreparedStatement ps = null;
        String[] loginString = DbCredentials.DbUser();

        try {
            //Data collection from file setup using location from database.
            BufferedReader reader = new BufferedReader(new FileReader(uploadFile));
            //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
            Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);

            //Extract data line by line, split and insert into database.
            String line = null;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                id = data[0];
                title = data[1];
                description = data[2];
                genre_id = data[3];
                price = data[4];
                author_id = data[5];
                publisher_id = data[6];
                publish_date = data[7];
                edition = data[8];
                qty = data[9];
                result = result.concat(id + "\t" + title + "\t" + description + "\t" + genre_id
                        + "\t" + price + "\t" + author_id + "\t" + publisher_id + "\t"
                        + publish_date + "\t" + edition + "\t" + qty + "\n");
                String sqlBookUpload =
                        "INSERT INTO books (id, title, description, genre_id, price, author_id,"
                                + "publisher_id, publish_date, edition, qty) values "
                                + "('" + id + "', '" + title + "', '" + description + "', '"
                                + genre_id + "', '" + price + "', '" + author_id + "', '"
                                + publisher_id + "', '" + publish_date + "', '"
                                + edition + "', '" + qty + "');";
                ps = conn.prepareStatement(sqlBookUpload);
                ps.executeUpdate();
            }
            result = result.concat("\nBooks Upload Finished..");

            reader.close();
            conn.close();
            ps.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * The method manages upload into the publishers table in the database.
     * The database is logged into before data is read line by line from uploadFile,
     * split into separate attributes and inserted into the publishers table using
     * a defined query.
     * @param uploadFile Location of file from which to upload
     * @throws FileNotFoundException if data file cannot be accessed.
     * @throws SQLException if DriverManager.getConnection unable to successfully
     * execute update.
     * @return String returned to calling code outlining data uploaded
     */
    public static String publishersDataUpload(String uploadFile) throws FileNotFoundException, SQLException {

        //Genre table columns
        String publisher_id;
        String publisher_name;
        String address_1;
        String address_2;
        String address_3;
        String address_town;
        String address_county;
        String address_postcode;

        //result String
        String result = "";

        PreparedStatement ps = null;
        String[] loginString = DbCredentials.DbUser();

        try {
            //Data collection from file setup using location from database.
            BufferedReader reader = new BufferedReader(new FileReader(uploadFile));
            //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
            Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);

            //Extract data line by line, split and insert into database.
            String line;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                publisher_id = data[0];
                publisher_name = data[1];
                address_1 = data[2];
                address_2 = data[3];
                address_3 = data[4];
                address_town = data[5];
                address_county = data[6];
                address_postcode = data[7];
                result = result.concat(publisher_id + "\t" + publisher_name + "\t" + address_1 + "\t" + address_2
                        + "\t" + address_3 + "\t" + address_town + "\t" + address_county + "\t"
                        + address_postcode + "\n");
                String sqlPublisherUpload =
                        "INSERT INTO publishers (publisher_id, publisher_name, address_1, address_2, address_3, address_town,"
                                + "address_county, address_postcode) values "
                                + "('" + publisher_id + "', '" + publisher_name + "', '" + address_1 + "', '"
                                + address_2 + "', '" + address_3 + "', '" + address_town + "', '"
                                + address_county + "', '" + address_postcode + "');";
                ps = conn.prepareStatement(sqlPublisherUpload);
                ps.executeUpdate();
            }
            result = result.concat("\nPublishers Upload Finished..");

            reader.close();
            conn.close();
            ps.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
/**
 * The method manages upload into the Users table in the database.
 * The database is logged into before data is read line by line from uploadFile,
 * split into separate attributes and inserted into the Users table using
 * a defined query.
 * @param uploadFile Location of file from which to upload
 * @throws FileNotFoundException if data file cannot be accessed.
 * @throws SQLException if DriverManager.getConnection unable to successfully
 * execute update.
 * @return String returned to calling code outlining data uploaded
 */
    public static String userDataUpload(String uploadFile) throws FileNotFoundException, SQLException {

        //Users table columns
        String user_id;
        String user_password;

        //result String
        String result = "";

        PreparedStatement ps = null;
        String[] loginString = DbCredentials.DbUser();

        try {
            //Data collection from file setup using location from database.
            BufferedReader reader = new BufferedReader(new FileReader(uploadFile));
            //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
            Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);

            //Extract data line by line, split and insert into database.
            String line;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                user_id = data[0];
                user_password = data[1];
                result = result.concat(user_id + "\t *Password*" + "\n");
                String sqlUsersUpload =
                        "INSERT INTO users (user_id, user_password) values "
                                + "('" + user_id + "', '" + user_password + "');";
                ps = conn.prepareStatement(sqlUsersUpload);
                ps.executeUpdate();
            }
            result = result.concat("\nUsers Upload Finished..");

            reader.close();
            conn.close();
            ps.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * The method manages upload into the settings table in the database.
     * The database is logged into before data is read line by line from uploadFile,
     * split into separate attributes and inserted into the settings table using
     * a defined query.
     * @param uploadFile Location of file from which to upload
     * @throws FileNotFoundException if data file cannot be accessed.
     * @throws SQLException if DriverManager.getConnection unable to successfully
     * execute update.
     * @return String returned to calling code outlining data uploaded
     */
    public static String settingsDataUpload(String uploadFile) throws FileNotFoundException, SQLException {

        //Settings table columns
        String setting_name;
        String value;

        //result String
        String result = "";

        PreparedStatement ps = null;
        String[] loginString = DbCredentials.DbUser();

        try {
            //Data collection from file setup using location from database.
            BufferedReader reader = new BufferedReader(new FileReader(uploadFile));
            //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
            Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);

            //Extract data line by line, split and insert into database.
            String line;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                setting_name = data[0];
                value = data[1];
                result = result.concat(setting_name + "\t" + value + "\n");
                String sqlSettingsUpload =
                        "INSERT INTO settings (setting_name, value) values "
                                + "('" + setting_name + "', '" + value + "');";
                ps = conn.prepareStatement(sqlSettingsUpload);
                ps.executeUpdate();
            }
            result = result.concat("\nSettings Upload Finished..");

            reader.close();
            conn.close();
            ps.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
