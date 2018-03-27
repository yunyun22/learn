package learn.wangjq.algorithm;

public class MySeacher {

    /**
     * binarySeracher
     * examp:
     * arrays : 1 4 5 7 8 10 23    (low=0,high=6,mid=3)
     * number : 8
     *
     * @param arrays
     * @param number
     * @return
     */
    public static int binarySeracher(int[] arrays, int number) {
        if (!MyArraysUtils.isSort(arrays)) {
            throw new RuntimeException("The arrays is not order");
        }
        int left = 0;
        int right = arrays.length - 1;
        int mid = arrays.length - 1 / 2;
        while (mid <= left || mid >= right) {
            mid = (left + right) / 2;
            if (number == arrays[mid]) {
                return mid;
            } else if (number > arrays[mid]) {
                left = mid + 1;
            } else {
                right = mid + 1;
            }
        }
        return -1;
    }

}
