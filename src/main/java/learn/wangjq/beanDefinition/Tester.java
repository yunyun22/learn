package learn.wangjq.beanDefinition;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.stereotype.Component;

@Component("t")
public class Tester {


    public static void main(String[] args) throws Exception {
//        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(Tester.class);
//        System.out.println(beanDefinition.getMetadata().getAnnotationTypes());
//        System.out.println(beanDefinition.isSingleton());
//        System.out.println(beanDefinition.getBeanClassName());
//        //System.out.println( beanDefinition.getFactoryMethodMetadata());
//
//        //实例化SimpleBeanDefinitionRegistry
//        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
//
//        //注册两个BeanDefinition
//        BeanDefinition definition_1 = new GenericBeanDefinition();
//        registry.registerBeanDefinition("d1", definition_1);
//
//        BeanDefinition definition_2 = new RootBeanDefinition();
//        registry.registerBeanDefinition("d2", definition_2);
//
//        //方法测试
//        System.out.println(registry.containsBeanDefinition("d1"));//true
//        System.out.println(registry.getBeanDefinitionCount());//2
//        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));//[d1, d2]
//
//
//        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(registry);
//        reader.register(Tester.class);
//        System.out.println(registry.getBeanDefinitionCount());


        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(defaultListableBeanFactory);

        int count = classPathBeanDefinitionScanner.scan("learn.wangjq.beanDefinition");

        System.out.println("count = " + count);

        Tester t = (Tester) defaultListableBeanFactory.getBean("t");

        System.out.println("t = " + t);

        String[] beanDefinitionNames = defaultListableBeanFactory.getBeanDefinitionNames();

        for (String s :
                beanDefinitionNames) {

            System.out.println("name = " + s);
        }
        TestDisposableBean testDisposableBean = (TestDisposableBean) defaultListableBeanFactory.getBean("testDisposableBean");

        Object object = (Object) defaultListableBeanFactory.getBean("myFactoryBean");

        MyFactoryBean myFactoryBean = (MyFactoryBean) defaultListableBeanFactory.getBean("&myFactoryBean");


        myFactoryBean.getObjectType();

        if (object instanceof String) {
            System.out.println("this class is " + myFactoryBean.getObjectType());
            System.out.println("object = " + object);
        }

        defaultListableBeanFactory.destroySingletons();
    }
}
