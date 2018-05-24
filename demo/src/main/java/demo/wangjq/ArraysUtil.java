package demo.wangjq;

import java.util.Arrays;

public class ArraysUtil {


    /**
     * 合并两个有序的数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {

        int[] ret = new int[left.length + right.length];

        int leftIndex = 0, rightIndex = 0, i = 0;
        for (; ; ) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    ret[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    ret[i] = right[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < left.length) {
                ret[i] = left[leftIndex];
                leftIndex++;
            } else if (rightIndex < right.length) {
                ret[i] = right[rightIndex];
                rightIndex++;
            } else {
                break;
            }
            i++;
        }
        return ret;
    }

    /**
     * 获取子数组
     *
     * @param src
     * @param from
     * @param to
     * @return
     */
    public static int[] subInt(int[] src, int from, int to) {
        if (src == null || src.length == 0) {
            return null;
        }
        return Arrays.copyOfRange(src, from, to - from);

    }

    /**
     * 正序获取value在数组中的index
     *
     * @param src
     * @param value
     * @return
     */
    public static int indexof(int[] src, int value) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] == value) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 倒序获取value在数组中的index
     *
     * @param src
     * @param value
     * @return
     */
    public static int lastIndexOf(int[] src, int value) {
        for (int i = src.length - 1; i > 0; i--) {
            if (src[i] == value) {
                return src.length - i;
            }
        }
        return -1;
    }

    /**
     * value 的length
     *
     * @param src
     * @param value
     * @return
     */
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


    /**
     * 将数组转换为字符串
     *
     * @param arrays
     * @return
     */
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
