package demo.wangjq.csapp;

/**
 * @author wang, jinqiao
 * @date 13/04/2021
 */
public class DataLab {

    public static int biXor(int x, int y) {
        return ~(~x & ~y) & ~(x & y);
    }

    public static void main(String[] args) {

        String s= "test";

        System.out.println(biXor(1, 0));
        System.out.println(biXor(0, 1));
        System.out.println(biXor(1, 1));
        System.out.println(biXor(0, 0));

    }
}
