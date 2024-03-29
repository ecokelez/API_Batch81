package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get14ObjectMapper_Map  extends JsonplaceholderBaseUrl {
      /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void test01() {
        //Set the Url
        spec.pathParams("first","todos","second",198);

        //Set the Expectd Data
       String expectedDataInString = new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);
        Map expectedData = ObjectMapperUtils.convertJsonToJava(expectedDataInString, Map.class);
        System.out.println("expectedData = " + expectedData);
        //Send the Request and Get  the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do Assertion
        Map actulaData = ObjectMapperUtils.convertJsonToJava(response.asString(), Map.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actulaData.get("userId"));
        assertEquals(expectedData.get("title"),actulaData.get("title"));
        assertEquals(expectedData.get("completed"),actulaData.get("completed"));


    }
}
