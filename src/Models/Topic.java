package Models;

public class Topic {
    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    private int topicID;
    private String topicName;

    public Topic(int topicID, String topicName) {

        //System.out.println("CREATE " + topicName);

        this.topicID = topicID;
        this.topicName = topicName;
    }

    @Override
    public String toString() {
        return topicName;
    }
}
