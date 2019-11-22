package demo.wangjq.app.beandefinition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;


/**
 * @author jinqwang
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("it is the bean beforeInitialization:" + bean);
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("it is the bean AfterInitialization:" + bean);
        return bean;
    }


    @Override
    public String toString() {
        return "It is MyBeanPostProcessor";
    }
}
