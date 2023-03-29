package patch_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Patch01 extends JsonplaceholderBaseUrl {
      /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */

    @Test
    public void patch01() {
        //Set the Url
        spec.pathParams("first","todos","second",198);

        //Set the Expected Data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedDataMap = obj.expectedDataMethod(null,"Wash the dishes",null);
        System.out.println("expectedDataMap : " + expectedDataMap);

        //Send the Response and Get the Request
       Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().patch("/{first}/{second}");
       response.prettyPrint();

       //Do Assertion
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap : " + actualDataMap);

        assertEquals(200,response.statusCode());
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));



    }
}
