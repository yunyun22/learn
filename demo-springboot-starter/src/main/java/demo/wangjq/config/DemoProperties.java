package demo.wangjq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wang, jinqiao
 * @title: DemoProperties
 * @date 10/12/2020
 */
@Component
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

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
}
