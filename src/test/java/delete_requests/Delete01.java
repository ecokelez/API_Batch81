package delete_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Delete01 extends JsonplaceholderBaseUrl {
       /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void test01() {
        //Set the url
        spec.pathParams("first","todos","second",198);
        //Set the Expected Data
        //Send the Request and Get the Response
       Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();
    }
}
