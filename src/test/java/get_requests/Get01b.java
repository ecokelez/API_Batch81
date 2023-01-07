package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01b {
      /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK

          => Test Case yazdık ve Url erismek icin Swagger dokuman ulasmak gerekir
           Swagger dokumnan. ise bana hangi EdnPoint'i- hangi Url'i ne is icin kullanmam gerek. soyleyecek,
           hangi body ile kullanmam gerek. soyleyecek

     */

    @Test
    public void get01() {
        //Set the Url
        String url = " https://reqres.in/api/users/3";

        //Set The Expected Data
        //Send The Request and Get The Response(User sends a GET Request to the url)
        Response response = given().when().get(url); //=> Url'i gonderdik ve response konteynra attık
        response.prettyPrint();

        //=> Do Assertion (dogrulama yapmak)
        // HTTP Status Code should be 200
        //Content Type should be JSON
        //Status Line should be HTTP/1.1 200 OK

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");



    }
}
