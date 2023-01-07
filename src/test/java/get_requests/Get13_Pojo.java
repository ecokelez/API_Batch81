package get_requests;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get13_Pojo extends GoRestBaseUrl{

     /*
    1) Postman, manuel API testleri icin kullandik,
    2) Otomasyon testleri icin de Rest Assured Library kullancagiz.
    3) Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz;
        a) Gereksimleri anlamak,
        b) Test Case yaziyoruz
            i) Test Case yaziminda "Gherkin" dilini kullanacagiz. Bizler yazilim diline hakim olsak da, karsimizdaki
            kisiler hakim olmayabilir ama Gherkin ile yazilan testleri anlamak ta zorluk çekmeyeceklerdir.
            Gherkin dilinde kullanacagimiz keywordler;

            - Given : On kosullar,
            - When  : Yapilacak aksiyonlar icin (get(), put(), post(), patch() ve delete() )
            - Then  : Istek yaptiktan (request gonderdikten sonra) dogrulama
            - And   : Coklu islemlerde kullanacagiz

        c) Test Kodlarimizi Yazmaya Baslayacagiz

            i)  Set the URL,
            ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
            iii) Type code to send request ( Talep gondermek icin kod yazimi)
            iv) Do Assertion (dogrulama yapmak)
     */

     /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
             {
             "meta": null,
             "data": {
                "id": 2508,
                 "name": "Anaadi Malik",
                 "email": "anaadi_malik@lang.name",
                "gender": "female",
                "status": "inactive"
               }
            }

      */

    @Test
    public void test01() {
        //Set the Url
        spec.pathParams("first","users","second",2508);
        //Set the Expected Data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508,"Anaadi Malik","anaadi_malik@lang.name","female","inactive");
        GoRestPojo expectedData = new GoRestPojo(null,goRestDataPojo);
        //Send the Request and Get the Response
       Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();
       //Do Assertion
        GoRestPojo actualData = response.as(GoRestPojo.class); // Response yani Json formatını Pojo cevirmis olduk
        System.out.println("actualData = " + actualData);
        /*
        {
         "meta": null,    =======>>> response yani  JSON
        "data": {
                "id": 2508,
                "name": "Anaadi Malik",
                "email": "anaadi_malik@lang.name",
                "gender": "female",
                "status": "inactive"
            }
        }   ===>> POJO'ya cevirmis olduk asagida !!!

    actualData = GoRestPojo{meta=null, data=GoRestDataPojo{id=2508, name='Anaadi Malik',
    email='anaadi_malik@lang.name', gender='female', status='inactive'}}
         */

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(goRestDataPojo.getId(),actualData.getData().getId());
        assertEquals(goRestDataPojo.getName(),actualData.getData().getName());
        assertEquals(goRestDataPojo.getEmail(),actualData.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(),actualData.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(),actualData.getData().getStatus());


    }
}


