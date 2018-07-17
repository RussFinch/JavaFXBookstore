package SqlQuery;

import Database.DbConnection;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PublisherSearch {

    public static ArrayList<String[]> Id(String publisherDetail)
            throws FileNotFoundException {

        String sqlPubSearch = "SELECT * FROM publishers WHERE publisher_id = '"
                + publisherDetail + "';";

        ArrayList<String[]> publisher;
        publisher = new ArrayList<>(DbConnection.Manager(sqlPubSearch));

        return publisher;
    }

    public static ArrayList<String[]> Name(String publisherDetail)
            throws FileNotFoundException {

        String sqlPubSearch = "SELECT * FROM publishers WHERE publisher_name = '"
                + publisherDetail + "';";

        ArrayList<String[]> publisher;
        publisher = new ArrayList<>(DbConnection.Manager(sqlPubSearch));

        return publisher;
    }
}