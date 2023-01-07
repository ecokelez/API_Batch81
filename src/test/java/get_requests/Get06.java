package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertTrue;

public class Get06 extends RestfulBaseUrl {
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
   {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}
}

     */

    @Test
    public void get01() {
        //i) Set the URL,
        spec.pathParams("first","booking","second",1922);
        //ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //iii) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //iv) Do Assertion (dogrulama yapmak)
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Josh"),
                        "lastname",equalTo("Allen"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("super bowls"));

        // 2. Yol : Jsonpath class'nın kullanimi
        JsonPath json = response.jsonPath();

        assertEquals("Josh",json.getString("firstname"));
        assertEquals("Allen",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertTrue(json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("super bowls",json.getString("additionalneeds"));

        // 3. Yol : SoftAssert
        // softAssert class 3 adimda kullanilir

        // i) Obje olusturma
        SoftAssert softAssert = new SoftAssert();
        // ii) Do Assertion ( dogrulama Yapma)
        softAssert.assertEquals(json.getString("firstname"),"Janny","firstname hatali");
        softAssert.assertEquals(json.getString("lastname"),"Allen","lastname dogru");
        softAssert.assertEquals(json.getInt("totalprice"),1111,"total price hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01","bookingdates.checkin dogru");
       softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01","bookingdates.checkout dogru");
       softAssert.assertEquals(json.getString("additionalneeds"),"super bowls","additionalneeds dogru");
       softAssert.assertAll();

        //iii) Dogrulama islemleri sonunda softAssert.assertAll() diyerek yaptigimiz tum dogrulama islemlerinin
        //==> kontrol edilmesini sagliyoruz.
        //==> Eger islemin sonunda softAssert.assertAll() kullanmaz isek taleplerimiz hatalı bile olsa testimiz pass olacaktir.


    }
}
