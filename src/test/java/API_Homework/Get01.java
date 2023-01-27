package API_Homework;

import base_url.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get01 extends AutomationExerciseBaseUrl {
    /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
    */

    @Test
    public void get01() {
        //Set the Url
        spec.pathParam("first","brandsList");
        //Set the Expected Data
        //Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //Do Assertion
        response.then().assertThat().
                statusCode(404).
                contentType("text/html").
                statusLine("HTTP/1.1 200 OK");

        JsonPath jsonPath = response.jsonPath();
       List<String> brandList = response.jsonPath().getList("brands.brand");
        System.out.println(brandList);

        int numHM = 0;
        int numPolo = 0;
        for (String w:brandList) {

            if (w.equals("HM")){
                numHM++;
            }
            if (w.equals("numPolo")){
                numPolo++;
            }
        }

        assertEquals(numHM,numPolo);

    }
}
