package demo.wangjq.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class FindFaultNumber {


    public static void findNumber(int[] num1, int[] num2) {

        if (num1 == null || num2 == null) {
            throw new RuntimeException("param is  error");
        }
        int xor1 = Arrays.stream(num1).reduce(0, (a, b) -> a ^ b);
        int xor2 = Arrays.stream(num2).reduce(0, (a, b) -> a ^ b);

    }


    @Test
    public void testFindFaultNumber() {

        int[] num1 = {1, 3, 4, 5, 6};
        int[] num2 = {1, 2, 3, 4, 5};

        findNumber(num1, num2);


    }

}
