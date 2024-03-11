package entities;

public class XCase {
    private XClient client;
    private String user;
    private XTopic topic;
    private int number;

    public XCase(XTopic topic, XClient client, String userName) {
        this.client = client;
        this.topic = topic;
        this.user = userName;
        this.number = (int) (Math.random() * 2000);
    }

    public String getClientInfo() {
        return client.getInfo();
    }

    public XClient getClient() {
        return client;
    }

    public String getName() {
        return topic.getName();
    }

    public String getDescription() {
        return topic.getDescription();
    }



    public String getUser() {
        return user;
    }

    public XTopic getTopic() {
        return topic;
    }

    public String getNumber() {
        return String.valueOf(number);
    }




}
