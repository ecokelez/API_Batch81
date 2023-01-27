package API_Homework;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import post_requests.test_data.ReqresTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Put01_Map extends ReqresBaseUrl {
    /*
        Given
            1) https://reqres.in/api/users/2
            2) {
                "name": "morpheus",
                "job": "zion president"
                }
        When
            I send Put Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "zion president",
                                                "updatedAt": "2022-10-02T11:35:05.693Z"
                                            }
*/

    @Test
    public void put01() {
        //Set the Url
        spec.pathParams("first","users","second",2);
        //Set the Expected Data
        ReqresTestData obj = new ReqresTestData();
        Map<String,String> expectedData = obj.expectedDataMethod("morpheus","zion president");
        System.out.println("expectedData = " + expectedData);
        //Send the Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");
        response.prettyPrint();
        //Do Assertion
        Map<String,String> actualDataMap =  response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);
        assertEquals(expectedData.get("name"),actualDataMap.get("name"));
        assertEquals(expectedData.get("job"),actualDataMap.get("job"));

    }
}
