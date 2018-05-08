package learn.wangjq.beanDefinition;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component("myFactoryBean")
public class MyFactoryBean implements FactoryBean {
    @Nullable
    @Override
    public Object getObject() throws Exception {
        return "wangjq";
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public String toString() {
        return "MyFactoryBean{}";
    }
}
