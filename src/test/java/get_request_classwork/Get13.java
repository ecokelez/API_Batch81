package get_request_classwork;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get13 extends RestfulBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/91
        When
            I send GET Request to the url
        Then
            Response body should be like that;
           {
       "firstname": "Joe",
       "lastname": "Rincon",
       "totalprice": 111,
       "depositpaid": true,
       "bookingdates": {
           "checkin": "2018-01-01",
           "checkout": "2019-01-01"
       },
       "additionalneeds": "Breakfast"
         } */

    @Test
    public void tets01() {
        //Set the Url
        spec.pathParams("first","booking","second",91);
        //Set the Expected Data
        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");

        Map<String,Object> expectedDataMap = new HashMap<>();

        expectedDataMap.put("firstname","Joe");
        expectedDataMap.put( "lastname","Rincon");
        expectedDataMap.put( "totalprice",111);
        expectedDataMap.put(  "depositpaid", true);
        expectedDataMap.put(  "bookingdates",bookingdatesMap);
        expectedDataMap.put( "additionalneeds","Breakfast");
        System.out.println("expectedDataMap : " + expectedDataMap);

        //Set the Request and Get the Response
         Response response = given().spec(spec).when().get("/{first}/{second}");
         response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualDataMap = response.as(HashMap.class);

        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(bookingdatesMap.get("checkin"),((Map)(actualDataMap.get("bookingdates"))).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)(actualDataMap.get("bookingdates"))).get("checkout"));
        assertEquals(expectedDataMap.get("additionalneeds"),(actualDataMap.get("Breakfast")));
        //Key-Value ikilileri String-Object şeklinde olduğundan, Bookingdata value kısmını casting ile Map yaptık.
    }
}
