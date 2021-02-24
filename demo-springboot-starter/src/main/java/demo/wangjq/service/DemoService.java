package demo.wangjq.service;

/**
 * @author wang, jinqiao
 * @title: DemoService
 * @date 10/12/2020
 */
public class DemoService {

    private String name;

    private String age;

    public DemoService(String name, String age) {
        this.name = name;
        this.age = age;
    }


    public void sayHello() {
        System.out.println("hello name,I am " + age);
    }
}
