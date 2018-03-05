package learn.wangjq.BeanDefinition;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component("testDisposableBean")
public class TestDisposableBean implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("I will destory");
    }
}
