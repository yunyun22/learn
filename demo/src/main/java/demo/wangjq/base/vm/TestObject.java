package demo.wangjq.base.vm;

import org.openjdk.jol.vm.VM;

/**
 * @author wang, jinqiao
 * @date 19/07/2021
 */
public class TestObject {


    final byte[] b1 = new byte[1024 * 1024];

    /**
     * -Xms10m -Xmx10m -XX:+PrintGC
     * @param args
     */
    public static void main(String[] args) {
        TestObject testObject = new TestObject();
        byte[] b1 = testObject.b1;
        long l = VM.current().addressOf(b1);
        System.out.println(l);
        System.gc();
        byte[] b2 = new byte[1024 * 1024 * 2];
        byte[] b3 = new byte[1024 * 1024];
        long l2 = VM.current().addressOf(b1);
        System.out.println(l2);

    }
}
