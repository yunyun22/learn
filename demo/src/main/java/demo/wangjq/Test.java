package demo.wangjq;

import java.time.Instant;

import static java.time.temporal.ChronoField.MICRO_OF_SECOND;

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
        for (int i = 0; i < 1000000; i++) {


            System.currentTimeMillis();


            Instant now = Instant.now();

            Instant after = Instant.now();

            Long duration = after.getLong(MICRO_OF_SECOND) - now.getLong(MICRO_OF_SECOND);
            // after.getNano()

            System.out.println(duration);

            //LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());


            // System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS")) + " " + after.getNano() % 1000L);


        }

    }

}
