package Database;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class manages search data generated by Genre searches.
 * It
 * @author russellfincham
 * @version 0.1
 * @since 04-07-18
 */

public class Search {
    /**
     * This method manages the collection and output of data generated by a search
     * of the books table.
     * It receives the query which it then passes to the database.  This method
     * then displays the results to the Main user Interface.
     * @throws FileNotFoundException if data file cannot be accessed by
     * DbCredentials.DbUser.
     * @param sqlQuery query to be presented to the database.
     * @return String returned to calling code indicating "Executed".
     */
    public static String DbSearch (String sqlQuery) throws FileNotFoundException {

        String loginString = DbCredentials.DbUser();

        String data[] = loginString.split(",");
        String userName = data[0];
        String password = data[1];
        String dbUrl = data[2];

        try (
                Connection conn = DriverManager.getConnection(dbUrl, userName, password);
                Statement stmt = conn.createStatement();
        ) {

            ResultSet rset = stmt.executeQuery(sqlQuery);

            int rowCount = 0;

            System.out.println("GENRE ID:\tGENRE NAME:");

            while (rset.next()) {
                String genre_id = rset.getString("genre_id");
                String genre_name = rset.getString("genre_name");

                System.out.println(genre_id + "\t\t" + genre_name);
                ++rowCount;
            }

            System.out.println("Total records = " + rowCount);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return "Executed";
    }
}
