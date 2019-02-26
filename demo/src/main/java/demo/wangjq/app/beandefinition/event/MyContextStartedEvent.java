package demo.wangjq.app.beandefinition.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextStartedEvent;

public class MyContextStartedEvent extends ContextStartedEvent {
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that has been started
     *               (must not be {@code null})
     */
    public MyContextStartedEvent(ApplicationContext source) {
        super(source);
    }

    @Override
    public String toString() {
        return "MyContextStartedEvent";
    }
}
