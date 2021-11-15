package demo.wangjq.base.thread.escape;

import java.util.concurrent.TimeUnit;

/**
 * @author wjq
 * @since 2021-10-08
 */
public class ThisSafe {

    public final int id;
    public final String name;
    private final EventListener listener;

    private ThisSafe() {
        id = 1;
        listener = new EventListener(){
            @Override
            public void onEvent(Object obj) {
                System.out.println("id: "+ThisSafe.this.id);
                System.out.println("name: "+ThisSafe.this.name);
            }
        };
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "flysqrlboy";
    }

    public static ThisSafe getInstance(EventSource<EventListener> source) {
        ThisSafe safe = new ThisSafe();
        source.registerListener(safe.listener);
        return safe;
    }
}
