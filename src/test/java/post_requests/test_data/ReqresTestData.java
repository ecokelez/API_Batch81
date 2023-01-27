package post_requests.test_data;

import java.util.HashMap;
import java.util.Map;

public class ReqresTestData {

    public Map<String,String> expectedDataMethod (String name,String job){

        Map<String,String> expectedDataMap = new HashMap<>();
        expectedDataMap.put("name",name);
        expectedDataMap.put("job",job);

        return expectedDataMap;
    }

    public String expectedDataInString(String name){
        //Dinamik expectedData methodu;Json datayı String bir container olarak return ediyor
        String expectedData = "{\n" +
                "                 \"name\": "+name+",\n" +
                "               }";

        return expectedData;

    }

}
