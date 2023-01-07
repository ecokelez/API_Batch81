package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get04b extends base_url.RestfulBaseUrl {
     /*
        Given
           https://restful-booker.herokuapp.com/booking? firstname=John&lastname=Smith
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "John" and lastname is "Smith"

     */
             // Set the Url
            //Set The Expected Data
           //Send The Request and Get The Respons
          //=> Do Assertion


    @Test
    public void get04() {
        // Set the Url
        spec.pathParams("first","booking").queryParam("firstname","John","lastname","Smith");
        //Set The Expected Data
        //Send The Request and Get The Respons
       Response response =  given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //=> Do Assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains(""));

    }
}
