package demo.wangjq.base.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author:wangjq
 * @Date: 2019/8/30 10:07
 */
public class TestLocalDateTime {

    public static void main(String[] args) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.parse("2020-01-31 00:00:00", dateTimeFormatter);

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}
