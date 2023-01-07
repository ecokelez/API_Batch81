package get_request_classwork;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get09 extends RestfulBaseUrl {
           /*
              Given
                  https://restful-booker.herokuapp.com/booking/1922
              When
                  User send a GET request to the URL
              Then
                  HTTP Status Code should be 200
              And
                  Response content type is "application/json"
              And
                  Response body should be like;

          "firstname": "John",
          "lastname": "Smith",
          "totalprice": 111,
          "depositpaid": true,
          "bookingdates": {
              "checkin": "2018-01-01",
              "checkout": "2019-01-01"
          },
          "additionalneeds": "Breakfast"

     */

    @Test
    public void test01() {
        // Set the Url
        spec.pathParams("first","booking","second","1922");
        //Set The Expected Data
        //Send The Request and Get The Response
       Response response =  given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

        //=> Do Assertion
        //1.yol
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname",equalTo("John"),
                        "lastname",equalTo("Smith"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("Breakfast"));

        // 2. Yol : Jsonpath class'nın kullanimi
        JsonPath jsonPath = response.jsonPath();
        assertEquals("John",jsonPath.getString("firstname"));
        assertEquals("Smith",jsonPath.getString("lastname"));
        assertEquals(111,jsonPath.getInt("totalprice"));
        assertTrue(jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
        assertEquals("Breakfast",jsonPath.getString("additionalneeds"));

        // 3. Yol : SoftAssert
        // softAssert class 3 adimda kullanilir

        // i) Obje olusturma
        SoftAssert softAssert = new SoftAssert();
        // ii) Do Assertion ( dogrulama Yapma)
        softAssert.assertEquals(jsonPath.getString("firstname"),"John");
        softAssert.assertEquals(jsonPath.getString("lastname"),"Smith");
        softAssert.assertEquals(jsonPath.getInt("totalprice"),111);
        softAssert.assertEquals(jsonPath.getBoolean("true"),"depositpaid");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"),"Breakfast");
        softAssert.assertAll();

        //iii) Dogrulama islemleri sonunda softAssert.assertAll() diyerek yaptigimiz tum dogrulama islemlerinin
        //==> kontrol edilmesini sagliyoruz.
        //==> Eger islemin sonunda softAssert.assertAll() kullanmaz isek taleplerimiz hatalı bile olsa testimiz pass olacaktir.




    }
}
