package demo.wangjq.base.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class DemoTest {

    /**
     * |------------------------------------------------------------------------------|--------------------|
     * |                                  Mark Word (64 bits)                         |       State        |
     * |------------------------------------------------------------------------------|--------------------|
     * | unused:25 | identity_hashcode:31 | unused:1 | age:4 | biased_lock:1 | lock:2 |       Normal       |
     * |------------------------------------------------------------------------------|--------------------|
     * | thread:54 |       epoch:2        | unused:1 | age:4 | biased_lock:1 | lock:2 |       Biased       |
     * |------------------------------------------------------------------------------|--------------------|
     * |                       ptr_to_lock_record:62                         | lock:2 | Lightweight Locked |
     * |------------------------------------------------------------------------------|--------------------|
     * |                     ptr_to_heavyweight_monitor:62                   | lock:2 | Heavyweight Locked |
     * |------------------------------------------------------------------------------|--------------------|
     * |                                                                     | lock:2 |    Marked for GC   |
     * |------------------------------------------------------------------------------|--------------------|
     *
     *
     * 结果前8位unused:1 | age:4 | biased_lock:1 | lock:2
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Demo1 demo1 = new Demo1();
        System.out.println(VM.current().details());
        Thread.sleep(6000);
        synchronized (demo1) {
            System.out.println(ClassLayout.parseInstance(demo1).toPrintable());
        }
        //System.gc();
       // System.out.println(ClassLayout.parseInstance(demo1).toPrintable());
    }
}


class Demo1 {

}