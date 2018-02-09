package Models;

public class Questions {
    private int questionID;
    private int quizID;


    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String question;
    private String answer;

    public Questions(int questionID, int quizID, String question, String answer) {
        this.questionID = questionID;
        this.quizID = quizID;
        this.question = question;
        this.answer = answer;
    }

    public String toString() {
        return "Questions{" +
                "questionID = " + questionID +
                ", quizID = " + quizID +
                ", question = '" + question + '\'' +
                ", answer = '" + answer + '\'' +
                '}';
    }
}
