package get_request_classwork;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.*;

public class Get15 extends GoRestBaseUrl {
      /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=2"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Kannen Khatri", "Arun Jha PhD" and "Dipali Khatri" are among the users
        And
            The female users are less than or equals to male users
     */

    @Test
    public void get01() {
        //Set the Url
        spec.pathParams("first","users");
        //Set the Expected Data

        //Send the Request and Get the Response
       Response response = given().spec(spec).when().get("/{first}");
       response.prettyPrint();
        //Do Assertion
        // The value of "pagination limit" is 10
        response.then().
                assertThat().
                body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Arun Jha PhD","Kannen Khatri","Dipali Khatri"));

        //The female users are less than or equals to male users
        //1. yol :
       List<String> genders = response.jsonPath().getList("data.gender");
        System.out.println("genders : " + genders);
        int numFemale = 0;
        for (String w: genders) {
            if (w.equalsIgnoreCase("numFemale")){
                numFemale++;
            }
        }

        assertTrue(numFemale<=genders.size()-numFemale);

        //2.yol : Groovy Language ile ;
         List<String> femaleNames = response.jsonPath().getList("{data.findAll(it.gender=='female').name}");
        System.out.println("femaleNames : " + femaleNames);
       List<String> maleNames = response.jsonPath().getList("{data.findAll(it.gender=='male').name}");
        System.out.println("maleNames : " + maleNames);
    }
}
