package learn.wangjq.beanDefinition;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/config/ApplicationContextTest.xml");
        Student s = (Student) classPathXmlApplicationContext.getBean("student");
        System.out.println(s);
    }

}
