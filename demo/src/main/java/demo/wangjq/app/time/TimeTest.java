package demo.wangjq.app.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {

    public static void main(String[] args) {
//        LocalDate now = LocalDate.now();// 取当前日期
//        System.out.println("now = " + now);
//        LocalDate localDate = LocalDate.of(2017, 6, 1);// 根据年月日取日期，12月就是12：
//        System.out.println("localDate = " + localDate);
//        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
//        System.out.println("endOfFeb = " + endOfFeb);
//        localDate.getYear();//年
//        localDate.getMonth();//月
//        localDate.getDayOfMonth();//日
//        localDate.getDayOfYear();//年中的第几天
//        LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
//        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String date = "2017-07-17 11:11:23";
        LocalDateTime dateTime = LocalDateTime.parse(date, dateTimeFormatter);
        System.out.println(dateTime);
    }
}
