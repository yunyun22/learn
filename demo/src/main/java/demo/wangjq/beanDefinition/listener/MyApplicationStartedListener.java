package demo.wangjq.beanDefinition.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class MyApplicationStartedListener implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("i deal this the event:" + event);
    }
}
