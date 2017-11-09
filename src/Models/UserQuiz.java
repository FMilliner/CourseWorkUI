package Models;

public class
UserQuiz {
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int quizID;
    private int score;

    public UserQuiz(int userID, int quizID, int score) {
        this.userID = userID;
        this.quizID = quizID;
        this.score = score;
    }
}
