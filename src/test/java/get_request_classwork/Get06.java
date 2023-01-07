package get_request_classwork;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get06 extends JsonplaceholderBaseUrl {

        /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
          I send a GET request to the Url
       And
           Accept type is "application/json"
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           There should be 200 todos
       And
           "quis eius est sint explicabo" should be one of the todos title
       And
           2, 7, and 9 should be among the userIds

            i)  Set the URL,
            ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
            iii) Type code to send request ( Talep gondermek icin kod yazimi)
            iv) Do Assertion (dogrulama yapmak)
        */

    @Test
    public void test01() {
        //Set the url
        spec.pathParam("first","todos");
        //Set The Expected Data
        //Send The Request and Get The Response( Talep gondermek icin kod yazimi)
       Response response =  given().spec(spec).when().accept(ContentType.JSON).get("/{first}");
       response.prettyPrint();
        //Do Assertion (dogrulama yapmak)
        response.then().assertThat().
                statusCode(200).contentType(ContentType.JSON).
                body("id",hasSize(200),
                       "title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2,7,9));
    }
}
