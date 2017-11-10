package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QuestionsService {

    public static void selectAll(List<Questions> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT QuestionID, QuizID, Question, Answer FROM Questions ORDER BY QuestionID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Questions(results.getInt("QuestionID"), results.getInt("QuizID"), results.getString("Question"), results.getString("Answer")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

}
