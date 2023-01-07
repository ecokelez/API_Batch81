package pojos;

public class Root_responseBodyPojo {
    private String status;
    private Data_dataPojo data;
    private String message;
    public String getStatus() {
        return status;
    }

    public Root_responseBodyPojo(String status, Data_dataPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Root_responseBodyPojo() {
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Data_dataPojo getData() {
        return data;
    }
    public void setData(Data_dataPojo data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Root{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
