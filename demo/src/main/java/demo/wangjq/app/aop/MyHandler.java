package demo.wangjq.app.aop;

public class MyHandler {

    public void beforeSayHello(){
        System.out.println("hi,hello");
    }


    public void afterSayBye(){
        System.out.println("good bye");
    }

}