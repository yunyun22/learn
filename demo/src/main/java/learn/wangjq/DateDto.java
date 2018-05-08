package learn.wangjq;

import java.util.Date;

public class DateDto {
    private Date today;
    private String name;

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DateDto{" +
                "today=" + today +
                ", name='" + name + '\'' +
                '}';
    }
}
