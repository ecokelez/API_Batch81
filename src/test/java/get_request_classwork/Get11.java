package get_request_classwork;

import base_url.JsonplaceholderBaseUrl;
import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;

public class Get11 extends JsonplaceholderBaseUrl {
    /*
      Given
            https://jsonplaceholder.typicode.com/todos
    When
     I send GET Request to the URL == > URL'e Get Request gonderin
    Then
     1)Status code is 200 == > Status kodu 200 olmali
     2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
       Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
     3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
       Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
     4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
       Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
       basliginin "delectus aut autem" icerdigini dogrulayin
   */

    @Test
    public void test01() {
        //Set the Url
        spec.pathParam("first","todos");
        //Set the Request and Get the Response
       Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //Do Assertion
        //1)Status code is 200
        assertEquals(200,response.statusCode());
        //2)Print all ids greater than 190 on the console
        JsonPath json = response.jsonPath();
        List<Integer> ids = json.getList("findAll{it.id>190}.id");
        System.out.println("idList : " + ids);
        //Assert that there are 10 ids greater than 190
        assertEquals(10,ids.size());
        //3)Print all userIds whose ids are less than 5 on the console
         List<Integer> userIdList = json.getList("findAll{it.id<5}.userId");
        System.out.println("userIds : " + userIdList);
        // Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals(4,userIdList.size());
        // 4)Print all titles whose ids are less than 5
        List<String> titleList = json.getList("findAll{it.id<5}.title");
        System.out.println("titleList : " + titleList);
        //Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue(titleList.contains("delectus aut autem"));

        assertTrue("Id'si 5 den kucuk olan title'lardan herhangi bir tanesi delectus aut autem icermemektedir.",
                titleList.stream().anyMatch(t->t.equals("delectus aut autem")));


    }
}
