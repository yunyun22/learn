package learn.wangjq.beanDefinition;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("testDisposableBean")
public class TestDisposableBean implements DisposableBean, BeanNameAware, BeanFactoryAware {


    @Value("wangjq")
    private String name;
    private String beanName;
    private BeanFactory beanFactory;
    private float myFloat;

    @Autowired
    private Tester Tester;


    @Override
    public void destroy() throws Exception {
        System.out.println("this object is " + name);
        System.out.println("I will destory");
        System.out.println("beanName = " + beanName);
        System.out.println("beanFactory = " + beanFactory);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public learn.wangjq.beanDefinition.Tester getTester() {
        return Tester;
    }

    public void setTester(learn.wangjq.beanDefinition.Tester tester) {
        Tester = tester;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public float getMyFloat() {
        return myFloat;
    }

    public void setMyFloat(float myFloat) {
        this.myFloat = myFloat;
    }

    @Override
    public String toString() {
        return "TestDisposableBean{" +
                "name='" + name + '\'' +
                ", beanName='" + beanName + '\'' +
                ", beanFactory=" + beanFactory +
                ", myFloat=" + myFloat +
                ", Tester=" + Tester +
                '}';
    }
}
