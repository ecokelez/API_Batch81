package pojos;

public class Data_dataPojo {
    private String employeeName;
    private Integer employeeSalary;
    private Integer employeeAge;
    private String profileImage;
    private Integer id;
    public String getEmployeeName() {
        return employeeName;
    }

    public Data_dataPojo(String employeeName, Integer employeeSalary, Integer employeeAge, String profileImage, Integer id) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
        this.id = id;
    }

    public Data_dataPojo() {
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public Integer getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(Integer employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public Integer getEmployeeAge() {
        return employeeAge;
    }
    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }
    public String getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeAge=" + employeeAge +
                ", profileImage='" + profileImage + '\'' +
                ", id=" + id +
                '}';
    }
}
