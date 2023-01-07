package get_request_classwork;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get14 extends GoRestBaseUrl {
       /*
            Given
                https://gorest.co.in/public/v1/users/2986
            When
                User send GET Request to the URL
            Then
                Status Code should be 200
            And
                Response body should be like
                /*
             {
        "meta": null,
        "data": {
            "id": 2986,
            "name": "Agnivesh Dubashi",
            "email": "dubashi_agnivesh@smitham-weber.biz",
            "gender": "male",
            "status": "inactive"
          }
        }
     */

    @Test
    public void test01() {
        //Set the Url
        spec.pathParams("first","users","second",2986);
        //Set the Expected Data
        GoRestTestData objGoRest = new GoRestTestData();
        Map<String,String> dataKeyMap = objGoRest.dataKeyMapMethod("Agnivesh Dubashi","dubashi_agnivesh@smitham-weber.biz","male","inactive");

        Map<String,Object> expectedData = objGoRest.expectedDataMethod(null,dataKeyMap);
        System.out.println(expectedData);

        //Set the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(expectedData.get("meta"),actualData.get("meta"));
        assertEquals(dataKeyMap.get("name"),((Map)actualData.get("data")).get("name"));
        assertEquals(dataKeyMap.get("email"),((Map)actualData.get("data")).get("email"));
        assertEquals(dataKeyMap.get("gender"),((Map)actualData.get("data")).get("gender"));
        assertEquals(dataKeyMap.get("status"),((Map)actualData.get("data")).get("status"));
        assertEquals(200,response.statusCode());

    }
}
