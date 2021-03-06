package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    public static void selectAll(List<User> targetList, DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("SELECT UserID, UserName, Score FROM User ORDER BY UserID");
        try {
            if (statement != null) {
                ResultSet results = database.executeQuery(statement);
                if (results != null) {
                    while (results.next()) {
                        targetList.add(new User(results.getInt("UserID"), results.getString("UserName"), results.getInt("Score")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static void save(User itemToSave, DatabaseConnection database) {

        try {
                PreparedStatement statement = database.newStatement("INSERT INTO User (UserName, Score) VALUES (?, ?)");
                statement.setString(1, itemToSave.getUserName());
                statement.setInt(2, itemToSave.getScore());
                database.executeUpdate(statement);
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

}
