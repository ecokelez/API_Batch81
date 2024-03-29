package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonplaceholderBaseUrl {
    //De-Serialization: Json datayı Java objesine çevirme
    //Serialization: Java objesini Json formatına çevirme.
    //De-Serialization: Iki türlü yapacağız.
    //Gson: Google tarafından üretilmiştir.
    //Object Mapper: Daha popüler...

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get08() {
        // Set the Url
        spec.pathParams("first","todos","second",2);
        //Set The Expected Data ==> payload
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println(expectedData);
        //==> Hasmap sıra gozetmedigi icin daha hızlıdır
        //De-Serialization - Serialization islemleri icin Java Obj ihtiyac vardır

        //Send The Request and Get The Respons
         Response response = given().spec(spec).when().get("/{first}/{second}");
         response.prettyPrint();
        //=> Do Assertion
         Map<String,Object> actualData = response.as(HashMap.class); //De-Serialization
        System.out.println("actualData : " + actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("Via"),actualData.get("1.1 vegur"));
        assertEquals(expectedData.get("Server"),actualData.get("cloudflare"));
        assertEquals(200,response.statusCode());


    }
        // Dinamik yontem
    @Test
    public void get08b() {
        // Set the Url
        spec.pathParams("first","todos","second",2);

        //Set The Expected Data ==> payload
        JsonPlaceHolderTestData objJsonPlcHldr = new JsonPlaceHolderTestData();

        Map<String,Object> expectedData = objJsonPlcHldr.expectedDataMethod(1,"quis ut nam facilis et officia qui",false);
        System.out.println(expectedData);

        //Send The Request and Get The Respons
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //=> Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class); //De-Serialization
        System.out.println("actualData : " + actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        //assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("Via"),actualData.get("1.1 vegur"));
        assertEquals(expectedData.get("Server"),actualData.get("cloudflare"));
        assertEquals(200,response.statusCode());


    }
}
