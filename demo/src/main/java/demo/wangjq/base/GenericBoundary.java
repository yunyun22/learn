package demo.wangjq.base;

import java.util.List;

public class GenericBoundary {

    public static void main(String[] args) {
        List<String> list = null;

        test(list);

    }


    public static void test(List<? extends String> list) {

    }
}
