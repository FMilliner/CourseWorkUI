package Models;

public class User {
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    private String UserName;

    public User(int userID, String userName, int score, int totalScore) {
        this.userID = userID;
        UserName = userName;
        this.score = score;
        this.totalScore = totalScore;
    }

    private int score;
    private int totalScore;
}
