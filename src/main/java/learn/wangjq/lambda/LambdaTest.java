package learn.wangjq.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    //List<String> list = new ArrayList<>();
    public static void filter(Support support, String s) {
        if (support.support(s)) {
            System.out.println("s = " + s);
        }
    }

    public static void main(String[] args) {
        Support support = (s1) -> {
            if (s1.length() > 1) {
                return true;
            }
            return false;
        };
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add("" + i);
        }
        for (String s : list) {
            LambdaTest.filter(support, s);
        }


    }

}
