package entities;

public class XClient {
    private String name;
    private String foreName;
    private String phone;

    public XClient(String name, String foreName, String phone) {
        this.name = name;
        this.foreName = foreName;
        this.phone = phone;
    }

    public String getInfo() {
        return name + " " + foreName;
    }

    public String getName() {
        return name;
    }

    public String getForeName() {
        return foreName;
    }

    public String getPhone() {
        return phone;
    }

}
