package demo.wangjq.ds;

import java.util.LinkedHashMap;
import java.util.Map;

public class DSTest {
    public static void main(String[] args) {

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(0,0.75f,true);
        linkedHashMap.put("1", "wangjq");
        linkedHashMap.put("2", "yuanyun");
        linkedHashMap.put("3", "wangxxx");

        linkedHashMap.get("2");
        linkedHashMap.get("1");


        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }

}
