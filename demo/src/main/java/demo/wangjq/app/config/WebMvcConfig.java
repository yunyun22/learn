package demo.wangjq.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

import demo.wangjq.app.component.MyHandlerMethodArgumentResolver;

/**
 * @author:wangjq
 * @Date: 2019/4/16 15:52
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new MyHandlerMethodArgumentResolver());
    }
}
