package SqlQuery;

import Database.DbConnection;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class builds search Genre query when
 * requested by Choice Box on delete Genre
 * interface.
 * @author russellfincham
 * @version 0.1
 * @since 17-07-18
 */
public class SearchGenre {
    /**
     * This method generates SQL following Genre selection when
     * using choicebox on delete Genre interface.
     * It generates the query which it then passes to the
     * database connection manager DbConnection.Manager. Results then
     * returned to DeleteGenreController.nameChoiceBoxSelection method
     * to populate interface with details corresponding to selection.
     * @Param genreDetail
     * @return ArrayList<String[]> result of SQL transaction.
     */
    public static ArrayList<String[]> Name(String genreDetail)
            throws FileNotFoundException {

        String sqlGenSearch = "SELECT * FROM genre WHERE genre_name = '"
                + genreDetail + "';";

        ArrayList<String[]> genre;
        genre = new ArrayList<>(DbConnection.Manager(sqlGenSearch));

        return genre;
    }
}