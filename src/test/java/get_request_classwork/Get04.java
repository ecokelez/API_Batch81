package get_request_classwork;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class Get04 extends JsonplaceholderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */

    //Set the url
    //Set The Expected Data
    //Send The Request and Get The Response( Talep gondermek icin kod yazimi)
    //Do Assertion (dogrulama yapmak)


    @Test
    public void test01() {
        //Set the url
        spec.pathParams("first","todos","second",23);
        //  ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //  iii) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do Assertion (dogrulama yapmak)
        //=> 1.yol => Hard Assert
        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body( "completed",equalTo(false)).
                body( "userId",equalTo(2));

        //=> 2. yol => Soft Assert
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(2));




    }
}
