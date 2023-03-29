package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String,Object> expectedDataMethod(Integer userId,String title,Boolean copmpleted){

        Map<String,Object> expectedDataMap = new HashMap<>();

        if (userId!=null){
            expectedDataMap.put("userId",userId);
        }

        if (title!=null){
            expectedDataMap.put("title",title);
        }

        if (copmpleted!=null){
            expectedDataMap.put("completed",copmpleted);
        }


        expectedDataMap.put("userId",userId);
        expectedDataMap.put("title",title);
        expectedDataMap.put("completed",copmpleted);

        return expectedDataMap;
    }


    public String expectedDataInString(int userId,String title,Boolean completed){
        //Dinamik expectedData methodu;Json datayı String bir container olarak return ediyor
        String expectedData = "{\n" +
                "                 \"userId\": "+userId+",\n" +
                "                 \"title\": \""+title+"\",\n" +
                "                 \"completed\": "+completed+"\n" +
                "               }";

        return expectedData;
    }

}
