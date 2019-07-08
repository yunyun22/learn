package demo.wangjq.algorithm.dp;

/**
 * @author wangjq
 */
public class MatrixChainMultiProblem {


    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();


        test();

    }


    /**
     * 矩阵计算次数的最优解
     *
     * @param matrix 矩阵 其中index==length-1时，是最后矩阵的列
     * @return 最优解
     */
    public static int minMatrixChainCount(int[] matrix) {

        int n = matrix.length - 1;

        /**
         * 矩阵的个数
         */
        int l = n - 1;

        int[][] opt = new int[n - 1][n - 1];

        for (int i = 0; i < n - 1; i++) {
            opt[i][i] = 0;
        }

        for (int d = 1; d < l; d++) {
            for (int i = 1; i < l - d; i++) {
                int j = i + d;
                for (int k = i + 1; k < j; l++) {
                    opt[i][j] = Math.min(opt[i][j], opt[i][k - 1] + opt[k][j] + matrix[i] * matrix[k] * matrix[j + 1]);
                }
            }
        }
        return opt[1][n - 1];
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


    public static void test() {

        for (int d = 0; d < 6; d++) {
            for (int i = 0; i < 6 - d; i++) {
                int j = i + d;
                System.out.print("i=" + i + ",j=" + j);
                System.out.print(" ");
            }

            System.out.println();
        }


    }

}
