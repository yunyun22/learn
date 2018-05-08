package learn.wangjq;

import java.util.Arrays;

public class ArraysUtil {

    public static int[] subInt(int[] src, int from, int to) {
        if (src == null || src.length == 0) {
            return null;
        }
        return Arrays.copyOfRange(src, from, to - from);

    }

    public static int getLength(int[] src, int value) {
        if (src.length < value) {
            return -1;
        }

        for (int i = 0; i < src.length; i++) {
            if (src[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
