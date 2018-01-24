package learn.wangjq;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class MyResovleAnnotation implements BeanFactoryPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Application> map = beanFactory.getBeansOfType(Application.class);
        map.forEach((s, application) -> System.out.println("s = " + s + ",applicaiton:" + application));
        Application application = map.get("application");
        application.setList(Arrays.asList("111","222","333"));
        //applicationContext.getBeanNamesForAnnotation();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
