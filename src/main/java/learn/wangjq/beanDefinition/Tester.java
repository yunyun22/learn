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
        //BeanPostProcessor beanPostProcessor = (BeanPostProcessor)defaultListableBeanFactory.getBean("myBeanPostProcessor");
        //System.out.println(beanPostProcessor);


        /**
         * test @Autowired
         */
//        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        autowiredAnnotationBeanPostProcessor.setBeanFactory(defaultListableBeanFactory);
//        defaultListableBeanFactory.addBeanPostProcessor(autowsiredAnnotationBeanPostProcessor);
////        Tester t = (Tester) defaultListableBeanFactory.getBean("t");
////        System.out.println(t);
//        TestDisposableBean testDisposableBean = (TestDisposableBean) defaultListableBeanFactory.getBean("testDisposableBean");
//        System.out.println(testDisposableBean);

        /**
         * test,learn BeanPostProcessor
         */
        //defaultListableBeanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
        //TestDisposableBean testDisposableBean = (TestDisposableBean) defaultListableBeanFactory.getBean("testDisposableBean");


        /**
         * test,learn conversion
         */
//        GenericConversionService conversionService = new DefaultConversionService();
//        conversionService.addConverter(new Converter<String, Float>() {
//            @Override
//            public Float convert(String source) {
//                try {
//                    NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
//                    return nf.parse(source).floatValue();
//                } catch (ParseException ex) {
//                    throw new IllegalArgumentException(ex);
//                }
//            }
//        });
//        defaultListableBeanFactory.setConversionService(conversionService);
//        MutablePropertyValues pvs = new MutablePropertyValues();
//        pvs.add("myFloat", "1,1");
//        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestDisposableBean.class);
//        rootBeanDefinition.setPropertyValues(pvs);
//        defaultListableBeanFactory.registerBeanDefinition("testDisposableBean", rootBeanDefinition);
//        TestDisposableBean testDisposableBean = (TestDisposableBean) defaultListableBeanFactory.getBean("testDisposableBean");
//
//        System.out.println("testDisposableBean.myFloat = " + testDisposableBean.getMyFloat());


        /**
         * test，learn PropertyEditor
         */
//        CustomEditorConfigurer cec = new CustomEditorConfigurer();
//
//        Map<Class<?>, Class<? extends PropertyEditor>> editors = new HashMap<>();
//        editors.put(String.class, MyCustomEditor.class);
//        cec.setCustomEditors(editors);
//        cec.postProcessBeanFactory(defaultListableBeanFactory);
//
//        MutablePropertyValues pvs = new MutablePropertyValues();
//        pvs.add("name", "www");
//        RootBeanDefinition bd = new RootBeanDefinition(TestDisposableBean.class);
//        bd.setPropertyValues(pvs);
//        defaultListableBeanFactory.registerBeanDefinition("tb", bd);
//        TestDisposableBean testDisposableBean = defaultListableBeanFactory.getBean(TestDisposableBean.class);
//        defaultListableBeanFactory.destroySingletons();

        //System.out.println("count = " + count);

        // defaultListableBeanFactory.registerSingleton("myString",new String("wangjq222"));

        //defaultListableBeanFactory.registerCustomEditor(String.class, MyCustomEditor.class);

        //Tester t = (Tester) defaultListableBeanFactory.getBean("t");

        // System.out.println("t = " + t);

        //String s = (String) defaultListableBeanFactory.getBean("myString");


        // System.out.println(s);
        //testDisposableBean.

        // defaultListableBeanFactory.destroySingletons();

        // System.out.println("myFactoryBeanStr = " + myFactoryBeanStr);

//        Object myFactoryBean = defaultListableBeanFactory.getBean("&myFactoryBean");
//
//        System.out.println("myFactoryBean = " + myFactoryBean);


//        if (o instanceof MyFactoryBean) {
//            System.out.println("o = " + o);
//        } else {
//            System.out.println("o = " + o);
//        }


//        String[] beanDefinitionNames = defaultListableBeanFactory.getBeanDefinitionNames();
//
//        for (String s :
//                beanDefinitionNames) {
//            System.out.println("s = " + s);
//
//        }
    }


    @Override
    public String toString() {
        return "Tester";
    }
}
