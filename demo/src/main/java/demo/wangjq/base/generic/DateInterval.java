package demo.wangjq.base.generic;

import java.time.LocalDate;

/**
 * @author wang, jinqiao
 * @title: DateInterval
 * @date 27/01/2021
 */
public class DateInterval extends Pair<LocalDate> {


    /**
     * 通过桥接来实现重载
     *
     * @param localDate localDate
     */
    public void setFirst(LocalDate localDate) {
        super.setSecond(localDate);
    }

    /**
     * 通过桥接来实现重载
     *
     * @return LocalDate
     */
    public LocalDate setFirst() {
        return super.getFirst();
    }

}
