package API_Homework;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.ReqresTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post01_Map extends ReqresBaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
*/

    @Test
    public void post01() {
        //Set the url
        spec.pathParam("first","users");
        //Set the Expected Data
        Map<String,String> expectedData = new HashMap<>();
        expectedData.put("name","morpheus");
        expectedData.put("job","leader");
        System.out.println("expectedData = " + expectedData);

        //=>2.yol
        ReqresTestData obj = new ReqresTestData();
        Map<String,String> expectedData2 = obj.expectedDataMethod("morpheus","leader");
        System.out.println("expectedData2 = " + expectedData2);
        //Send the Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData2).when().post("/{first}");
        response.prettyPrint();
        //Do Assertion
       Map<String,String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData2.get("name"),actualData.get("name"));
        assertEquals(expectedData2.get("job"),actualData.get("job"));


    }
}
