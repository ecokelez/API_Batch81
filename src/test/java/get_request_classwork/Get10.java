package get_request_classwork;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;

public class Get10 extends ReqresBaseUrl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void test01() {
        //Set the url
        spec.pathParams("first","unknown");
        //Set The Expected Data
        //Send The Request and Get The Respons
         Response response = given().spec(spec).when().get("/{first}");
         response.prettyPrint();
         //Do Assertion
        // ==> 1)Status code is 200
        //=> response.then().statusCode(200);
        assertEquals(200,response.statusCode());
        // 2)Print all pantone_values
        JsonPath json = response.jsonPath();
        System.out.println(json.getList("data.pantone_value"));
        //==> 3)Print all ids greater than 3 on the console
       List<Integer> ids = json.getList("data.findAll{it.id>3}.id");
        System.out.println("ids : " + ids);
        //   Assert that there are 3 ids greater than 3
        assertEquals(3,ids.size());

        // ==> 4)Print all names whose ids are less than 3 on the console
        List<String> nameList = json.getList("data.findAll{it.id<3}.name");
        System.out.println("names : " + nameList);
        //   Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2,nameList.size());





        }



        }



