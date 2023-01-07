package get_request_classwork;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
            /*
            ) Postman, manuel API testleri icin kullandik,
            ) Otomasyon testleri icin de Rest Assured Library kullancagiz.
            ) Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz;
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
                    https://restful-booker.herokuapp.com/booking/101
                When
                    User sends a GET Request to the url
                Then
                    HTTP Status Code should be 200
                And
                    Content Type should be JSON
                And
                    Status Line should be HTTP/1.1 200 OK
             */

    @Test
    public void test01() {
        // i)  Set the URL,
        String url = "https://restful-booker.herokuapp.com/booking/101";
        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        // iii) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response =given().when().get(url);
        response.prettyPrint();
        // iv) Do Assertion (dogrulama yapmak)
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");


    }
}
