package demo.wangjq.algorithm.dp;

/**
 * @author wangjq
 */
public class MatrixChainMultiProblem {


    public static void main(String[] args) {

        System.out.println(matrixChainCount(4));

    }


    public static int matrixChainCount(int n) {
        if (n == 1) {
            return 1;
        }
        int count = 0;

        for (int i = 1; i < n; i++) {

            count = count + matrixChainCount(i) * matrixChainCount(n - i);
        }

        return count;

    }


}
