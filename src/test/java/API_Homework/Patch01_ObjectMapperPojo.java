package API_Homework;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresNamePojo;
import pojos.ReqresPojo;
import utils.ObjectMapperUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Patch01_ObjectMapperPojo extends ReqresBaseUrl {
    //4: Map ile ve Pojo Class ile ayrı ayrı Object Mapper kullanarak yapınız.
  /*
       Given
           1) https://reqres.in/api/users/2
           2) {
               "name": "neo"
               }
       When
            I send PATCH Request to the Url
       Then
             Status code is 200
             And response body is like   {
                                                "name": "neo",
                                                "updatedAt": "2022-10-02T12:53:21.675Z"
                                         }
    */

    @Test
    public void patch01()  {
        spec.pathParams("first","users","second",2);
        ReqresNamePojo expectedData = new ReqresNamePojo("neo");
        System.out.println("expectedData = " + expectedData);
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");
        response.prettyPrint();
        ReqresNamePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), ReqresNamePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getName(), actualData.getName());
    }
}
