package learn.wangjq.beanDefinition;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component("myFactoryBean")
public class MyFactoryBean implements FactoryBean {
    @Nullable
    @Override
    public Object getObject() throws Exception {
        return "please,I am wangjq";
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return String.class;
    }
}
