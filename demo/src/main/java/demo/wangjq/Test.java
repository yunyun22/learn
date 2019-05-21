package demo.wangjq;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:wangjq
 * @Date: 2019/5/13 10:41
 */
public class Test {

    /**
     * 纳秒与当前系统时间的偏移量（ms）
     */
    private static final long NANO_OFFSET = System.nanoTime() - System.currentTimeMillis() * 1000000L;

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss SSS ");
        for (int i = 0; i < 1000000; i++) {
            long microsecond = getMicrosecondTime();
            Date date = new Date(microsecond / 1000L);
            System.out.println(simpleDateFormat.format(date) + (microsecond % 1000L));
        }
    }

    private static long getMicrosecondTime() {
        return (System.nanoTime() - NANO_OFFSET) / 1000L;
    }
}
