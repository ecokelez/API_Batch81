package get_request_classwork;

import base_url.ReqresBaseUrl;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends ReqresBaseUrl {
  /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
    }
      */

    @Test
    public void test01() {
        // Set the Url
        spec.pathParams("first","unknown","second",3);
        //Set The Expected Data
        //Send The Request and Get The Respons
       Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();
        //=> Do Assertion

        SoftAssert softAssert = new SoftAssert();
       JsonPath jsonPath = response.jsonPath();
        System.out.println(response.contentType());

        softAssert.assertEquals(response.getStatusCode(),200);
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getInt("data.id"),3);
        softAssert.assertEquals(jsonPath.getString("data.name"),"true red","name degeri dogru degil");
        softAssert.assertEquals(jsonPath.getInt("data.year"),2002,"yil degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932");
        assertEquals(jsonPath.getString("data.pantone_value"),"19-1664");
        assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading");
        assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!");

        softAssert.assertAll();




    }
}
