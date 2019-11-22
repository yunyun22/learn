package demo.wangjq.app.config;

import demo.wangjq.app.beanpostprocessor.MyInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wang, jinqiao
 * @title: DemoConfig
 * @date 21/11/2019
 */
@Configuration
public class DemoConfig {

    @Bean
    public MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }
}
