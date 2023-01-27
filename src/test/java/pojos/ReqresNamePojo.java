package pojos;

public class ReqresNamePojo {
    private String name;

    public ReqresNamePojo(String name) {
        this.name = name;
    }

    public ReqresNamePojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReqresNamePojo{" +
                "name='" + name + '\'' +
                '}';
    }
}
