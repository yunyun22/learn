package demo.wangjq.lintcode;


public class Solution {

    public static void main(String[] args) {
        int result = reverseInteger(123);
        System.out.println("result = " + result);
    }
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public static int reverseInteger(int number) {

        int i = number / 100;
        int j = (number - i * 100) / 10;
        int k = (number - i * 100) - j * 10;

        return k * 100 + j * 10 + i;
    }



}
