package Models;

public class Questions {
    private int quizID;
    private int questionID;

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
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

    public Questions(int quizID, int questionID, String question, String answer) {
        this.quizID = quizID;
        this.questionID = questionID;
        this.question = question;
        this.answer = answer;
    }

    public String toString() {
        return "Questions{" +
                "quizID=" + quizID +
                ", questionID=" + questionID +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
