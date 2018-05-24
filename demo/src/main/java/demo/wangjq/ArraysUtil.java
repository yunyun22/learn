package demo.wangjq;

import java.util.Arrays;

public class ArraysUtil {


    public static int[] subInt(int[] src, int from, int to) {
        if (src == null || src.length == 0) {
            return null;
        }
        return Arrays.copyOfRange(src, from, to - from);

    }

    public static int indexof(int[] src, int value) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(int[] src, int value) {
        for (int i = src.length - 1; i > 0; i--) {
            if (src[i] == value) {
                return src.length - i;
            }
        }
        return -1;
    }

    public static int getLength(int[] src, int value) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(lastIndexOf(ints, 7));
    }


    public static String arraysToString(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrays.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(arrays[i]);
        }
        return sb.toString();
    }
}
