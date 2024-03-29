package post_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {
    /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01() {
        //Set tge Url
        spec.pathParam("first","todos");

        //Set the Expected Data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData = obj.expectedDataMethod(55,"Tidy your room",false);

        //Send the Request and Get the Response
         Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
         response.prettyPrint();

         //Do Assertion
         Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData : " + actualData);

        assertEquals(expectedData.get("completed"),actualData.get("completed"));
         assertEquals(expectedData.get("userId"),actualData.get("userId"));
         assertEquals(expectedData.get("title"),actualData.get("title"));


    }
}
