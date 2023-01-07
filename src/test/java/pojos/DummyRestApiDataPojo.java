package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class DummyRestApiDataPojo {

    private String employee_name;
    private Integer employee_salary;
    private Integer employee_ag;
    private String profile_image;

    public DummyRestApiDataPojo(String employee_name, Integer employee_salary, Integer employee_ag, String profile_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_ag = employee_ag;
        this.profile_image = profile_image;
    }

    public DummyRestApiDataPojo() {
    }


    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_ag() {
        return employee_ag;
    }

    public void setEmployee_ag(Integer employee_ag) {
        this.employee_ag = employee_ag;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return "DummyRestApiDataPojo{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", employee_ag=" + employee_ag +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }
}
