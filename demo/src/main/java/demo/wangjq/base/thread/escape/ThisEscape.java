package demo.wangjq.base.thread.escape;

import java.util.concurrent.TimeUnit;

/**
 * @author wjq
 * @since 2021-10-08
 */
public class ThisEscape {
    public final int id;
    public final String name;

    public ThisEscape(EventSource<EventListener> source) {
        id = 1;
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Object obj) {
                System.out.println("id: " + ThisEscape.this.id);
                System.out.println("name: " + ThisEscape.this.name);
            }
        });
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "flysqrlboy";
    }


}
