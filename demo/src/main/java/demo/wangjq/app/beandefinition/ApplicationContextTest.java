package demo.wangjq.app.beandefinition;

import demo.wangjq.app.service.AopService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/config/ApplicationContextTest.xml");

        //classPathXmlApplicationContext.getMessage(null,null);
        //Student s = (Student) classPathXmlApplicationContext.getBean("student");
        //classPathXmlApplicationContext.publishEvent(new EmailEvent("hello Spring!", "cxg@126.com", "This is SpringApplicatoinContext test!"));
        //classPathXmlApplicationContext.publishEvent(new MyContextStartedEvent(classPathXmlApplicationContext));
        //System.out.println(s);

        AopService aopService = classPathXmlApplicationContext.getBean(AopService.class);

        aopService.doDealService();


    }

}

