package Models;

public class QuestionsService {

    public static void selectAll(List<Thing> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT x, y, z FROM Table ORDER BY x");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Thing(results.getInt("x"), results.getString("y"), results.getString("z")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

}
