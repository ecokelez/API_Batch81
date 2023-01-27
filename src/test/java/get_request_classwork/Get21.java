package get_request_classwork;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get21 extends DummyRestApiBaseUrl {
     /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                   iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */

    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
       User sends GET Request
    Then
       i) Status code is 200
    And
        ii) There are 24 employees
    And
        iii) "Tiger Nixon" and "Garrett Winters" are among the employees
    And
         iv) The greatest age is 66
    And
        v) The name of the lowest age is "Tatyana Fitzpatrick"
    And
        vi) Total salary of all employees is 6,644,770
     */

    @Test
    public void test01() {
        //Set the Url
        spec.pathParams("first","employees");
        //Set the Expected Data
        //Send the Request and Get the Response
       Response response = given().spec(spec).when().get("/{first}");
       response.prettyPrint();
       //Do Assertion
        //==> i) Status code is 200-
        //==> ii) There are 24 employees-
        //==> iii) "Tiger Nixon" and "Garrett Winters" are among the employees
        response.then().assertThat().
                statusCode(200).
                body("data.id",hasSize(24),
                "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));
        //==> iv) The greatest age is 66
        List<Integer> ages = response.jsonPath().getList("data.employee_age");
        System.out.println("ages = " + ages);
        Collections.sort(ages);
        System.out.println("ages = " + ages);
        System.out.println("The greatest age = " + ages.get(ages.size() - 1));
        assertEquals(66,(int)ages.get(ages.size()-1));
        //==> v) The name of the lowest age is "Tatyana Fitzpatrick"
        List<Integer> lowestAges = response.jsonPath().getList("data.findAll{it.employee_age == "+ages.get(0)+"}.employee_name");
        System.out.println("Name of lowestAge = " + lowestAges.toString());
        //==> vi) Total salary of all employees is 6,644,770
        List<Integer> salaries = response.jsonPath().getList("data.employee_salary");
        System.out.println("salaries = " + salaries);

        //==> 1. yol
        int sum = 0;
        for (int w:salaries) {
        sum+=w;
        }
        System.out.println("sum = " + sum);
        assertEquals(6644770,sum);
        //==> 2. yol - Lambda ile
        salaries.stream().reduce(0,(t,u)->t+u);
        int sum2 = salaries.stream().reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);
        assertEquals(6644770,sum2);
        //==> 3. yol- Lambda ile
        int sum3 = salaries.stream().reduce(0,Math::addExact);
        System.out.println("sum3 = " + sum3);
        assertEquals(6644770,sum3);
        //==> 4. yol - Lambda ile
        salaries.stream().forEach(System.out::println);

    }
}
