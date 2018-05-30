package demo.wangjq.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {

    public static void main(String[] args) {
        toArrays(1235468942);
    }

    public static int toArrays(Integer param) {

        int temp = param;

        List<Integer> list = new ArrayList<>();

        int i = 0;

        while (temp > 0) {
            list.add(temp % 10);
            temp /= 10;
        }

        for (int j = 0; j < list.size(); j++) {
            

        }


        int number = list.size();

        return 0;

    }

}
