package demo.wangjq.algorithm;

public class MyArraysUtils {

    public static boolean isSort(int arrays[]) {
        if (arrays == null) {
            throw new RuntimeException("arrays is not null");
        }
        if (arrays.length == 0) {
            return true;
        }
        boolean condition = true;
        for (int i = 0; i < arrays.length - 1; i++) {
            condition = condition && (arrays[i] < arrays[i + 1]);
        }
        return condition;
    }
}
