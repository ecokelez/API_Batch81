package get_request_classwork;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02 {
     /* Given
            https://restful-booker.herokuapp.com/booking/1
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 200
        And
            Status Line should be HTTP/1.1 200 OK
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void tets01() {
        //  i)  Set the URL,
        String url = " https://restful-booker.herokuapp.com/booking/1";
        //  ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //  iii) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();
        //  iv) Do Assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK");
        // Body'nin  Not Found icerip icermedigi
        assertFalse(response.asString().contains("Not Found"));
        // Body'nin  TechPro  icerip icermedigi
        assertFalse(response.asString().contains("TechProEd"));
        //Server'ın Not Cowboy icerip icermedigi
        assertEquals("Cowboy",response.getHeader("Server"));




    }
}
