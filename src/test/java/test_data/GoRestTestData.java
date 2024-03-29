package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {
    public Map<String,String> dataKeyMapMethod(String name,String email,String gender,String status){
        Map<String,String> dataKeyMap = new HashMap<>();
        //Asagıdaki  id degerini girmeyecegimiz icin geriye sadece Stringler kalıyor ve Obj. yapmaya gerek yok
        dataKeyMap.put("name",name);
        dataKeyMap.put("email",email);
        dataKeyMap.put("gender",gender);
        dataKeyMap.put("status",status);

        return dataKeyMap;
    }

    public Map<String,Object> expectedDataMethod(Object meta,Map<String,String>data){
        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("meta",meta);
        expectedDataMap.put("data",data);

        return expectedDataMap;
    }
}


        /*
            {
        "meta": null,
        "data": {
            "id": 2986,
            "name": "Agnivesh Dubashi",
            "email": "dubashi_agnivesh@smitham-weber.biz",
            "gender": "male",
            "status": "inactive"
          }
        }
         */
