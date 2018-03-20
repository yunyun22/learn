package learn.wangjq.beanDefinition;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component("testDisposableBean")
public class TestDisposableBean implements DisposableBean, BeanNameAware, BeanFactoryAware {


    private String name;
    private String beanName;
    private BeanFactory beanFactory;

    @Override
    public void destroy() throws Exception {
        System.out.println("this object is " + name);
        System.out.println("I will destory");
        System.out.println("beanName = " + beanName);
        System.out.println("beanFactory = " + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public String toString() {
        return "TestDisposableBean{" +
                "name='" + name + '\'' +
                ", beanName='" + beanName + '\'' +
                ", beanFactory=" + beanFactory +
                '}';
    }
}
