package learn.wangjq.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        list.stream().filter((s) -> {
            if (s > 100) {
                return true;
            } else {
                return false;
            }
        }).forEach(System.out::println);
    }

}
