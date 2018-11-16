package demo.wangjq.algorithm.dp;

/**
 * Created by wangjq on 2018/11/16.
 */
public class CoinProblem {


    public int d(int n) {
        if (n == 1 || n == 3 | n == 5) {
            return 1;
        }
        return min(d(n - 1), d(n - 3), d(n - 5));

    }

    public int min(int first, int second, int third) {
        int min = first < second ? first : second;
        return min < third ? min : third;
    }

}
