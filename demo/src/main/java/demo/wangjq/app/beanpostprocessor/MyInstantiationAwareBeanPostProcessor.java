package demo.wangjq.app.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author wang, jinqiao
 * @title: MyInstantiationAwareBeanPostProcessor
 * @date 21/11/2019
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    private static final String STUDENT = "student";

    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, STUDENT)) {
            System.out.print("beanName:" + beanName + "  pvs" + pvs);
            Arrays.asList(pds).forEach((pd) -> System.out.print("pd:" + pd));
            System.out.println();
            PropertyValue name = pvs.getPropertyValue("name");
            System.out.println("this propertyValue:" + name);
        }
        return pvs;
    }

}
