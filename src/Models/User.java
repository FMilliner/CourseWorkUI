package Models;

public class User {
    private int userID;
    private String UserName;
    private int score;

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


    public User(int userID, String userName, int score) {
        this.userID = userID;
        UserName = userName;
        this.score = score;
    }

}
