package Models;

public class Quiz {
    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    private int quizID;
    private String quizName;
    private int topicID;

    public Quiz(int quizID, String quizName, int topicID) {
        this.quizID = quizID;
        this.quizName = quizName;
        this.topicID = topicID;
    }
}
