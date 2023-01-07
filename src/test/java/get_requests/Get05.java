package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get05 extends RestfulBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
         ----------
             i) Set the URL,
            ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
            iii) Type code to send request ( Talep gondermek icin kod yazimi)
            iv) Do Assertion (dogrulama yapmak)
     */

    @Test
    public void get01() {

        // i) Set the URL,
        //https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith
        spec.pathParams("first","booking").queryParam("firstname","Johhny","lastname","Dear");

        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        // iii) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        // iv) Do Assertion (dogrulama yapmak)
        assertEquals(200,response.getStatusCode());
        assertFalse(response.asString().contains("bookingid"));


    }
}
