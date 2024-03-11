package entities;

public class XTopic {
    private String name;
    private String description;
    private String additional;

    public XTopic(String name, String description, String additional) {
        this.name = name;
        this.description = description;
        this.additional = additional;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditional() {
        return additional;
    }

}
