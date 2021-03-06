package Database;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manages connections to the Database.
 * @author russellfincham
 * @version 0.3
 * @since 17-07-18
 */

public class DbConnection {
    /**
    * This method manages Data collection from the database.
    * It receives the query which it then passes.  It generates
    * a ListArray of the results..
    * @throws java.io.FileNotFoundException if DbCredentials.DbUser missing login file.
    * DbCredentials.DbUser.
    * @param sqlQuery Query to be run against database.
    * @return ListArray String[] returned to calling method..
    */
    public static List<String[]> Manager(String sqlQuery) throws FileNotFoundException {

        List<String[]> resultTable = new ArrayList<>();
        String[] loginString = DbCredentials.DbUser();

        try (
                //loginString[0] = userName, loginString[1] = password, loginString[2] = DbUrl
                Connection conn = DriverManager.getConnection(loginString[2], loginString[0], loginString[1]);
                Statement stmt = conn.createStatement()
        ) {
            ResultSet rset = stmt.executeQuery(sqlQuery);
            int nCol = rset.getMetaData().getColumnCount();

            while (rset.next()) {
                String[] row = new String[nCol];
                for (int iCol = 1; iCol <= nCol; iCol++) {
                    Object obj = rset.getObject(iCol);
                    row[iCol - 1] = (obj == null) ? null : obj.toString();
                }
                resultTable.add(row);
            }

            //If results null build row 0 of list array to specify no
            // further results.
            if (!rset.next()) {
                String[] row = new String[nCol];
                for (int iCol = 1; iCol <= nCol; iCol++) {
                    row[iCol - 1] = "No Further Results";
                }
                resultTable.add(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultTable;
    }
}