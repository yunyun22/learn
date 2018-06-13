package demo.wangjq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by wangjq on 2018/6/13.
 */
@Component
@ConfigurationProperties(prefix = "student")
@PropertySource("classpath:student.properties")
public class Student {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyConfig{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
