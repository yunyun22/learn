package demo.wangjq.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class RodCuttingProblem {

    public static int[] value = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public static void main(String[] args) {
        System.out.println(profitDown(34));
    }

    public static Map<Integer, Integer> ret = new HashMap<>();

    static {
        ret.put(0, 0);
    }

    public static int profitUp(int n) {
        Integer integer = ret.get(n);
        if (integer != null) {
            return integer;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int v = i > 10 ? value[10] : value[i];
            max = Math.max(max, v + profitUp(n - i));
        }
        ret.put(n, max);
        return max;
    }

    public static int profitDown(int n) {
        int[] profit = new int[n + 1];
        profit[0] = 0;

        for (int i = 0; i <= n; i++) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                int v = j > 10 ? value[10] : value[j];
                max = Math.max(max, v + profit[i - j]);
            }
            profit[i] = max;
        }
        return profit[n];
    }

}
