package get_request_classwork;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class Get07 extends RestfulBaseUrl {
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
    public void test01() {
        // Set the Url
        spec.pathParam("first","booking").queryParam("firstname","Josh","lastname","Allen");
        //Set The Expected Data
        //Send The Request and Get The Respons
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //=> Do Assertion
        assertEquals(200,response.statusCode());
        assertFalse(response.asString().contains("bookingid"));





    }
}
