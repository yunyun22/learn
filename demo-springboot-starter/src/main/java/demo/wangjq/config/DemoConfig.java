package demo.wangjq.config;

import demo.wangjq.service.DemoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author wang, jinqiao
 * @title: DemoConfig
 * @date 10/12/2020
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(
        prefix = "demo",
        name = "enable",
        havingValue = "true"
)
public class DemoConfig {

    @Resource
    private DemoProperties demoProperties;

    @Bean(name = "demo")
    public DemoService demoService() {
        return new DemoService(demoProperties.getName(), demoProperties.getAge());
    }
}
