package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TopicService {

    public static void selectAll(List<Topic> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT TopicID, TopicName FROM Topic ORDER BY TopicID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Topic(results.getInt("TopicID"), results.getString("TopicName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

}