package demo.wangjq.util;

/**
 * @author wang, jinqiao
 * @date 12/08/2021
 */
public class Print {

    public static void printArray(Object[] objects) {

        if (objects == null || objects.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                System.out.print("null");
            } else {
                System.out.print(objects[i].toString());
            }
            if (i < objects.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
