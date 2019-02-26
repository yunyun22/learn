package demo.wangjq.base.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by wangjq on 2018/6/27.
 */

public class TestUnSafe {
    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {            // 反射获取 Unsafe 的成员变量 theUnsafe（2.2.10）
            Field field = Unsafe.class.getDeclaredField("theUnsafe");            // 设置为可存取（2.2.11）
            field.setAccessible(true);            // 获取该变量的值（2.2.12）
            unsafe = (Unsafe) field.get(null);            //获取 state 在 TestUnSafe 中的偏移量 （2.2.13）
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));

        } catch (Exception ex) {

            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }

    }

    public static void main(String[] args) {

//        TestUnSafe test = new TestUnSafe();
//        System.out.println(stateOffset);
//        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
//        System.out.println(sucess);


        System.out.println("begin park!");

        LockSupport.park();

        System.out.println("end park!");


    }
}