package demo.wangjq.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjq
 */
public class CoinProblem {

    public static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println("money:" + i + ",conins: " + d(i));
        }
    }

    public static int d(int n) {
        if (n == 1 || n == 3 | n == 5) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int min = d(n - 1) + 1;
        if (n >= 3) {
            int second = d(n - 3) + 1;
            min = min < second ? min : second;
        }
        if (n >= 5) {
            int third = d(n - 5) + 1;
            min = min < third ? min : third;
        }
        map.put(n, min);
        return min;
    }
}
