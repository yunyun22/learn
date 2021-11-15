package demo.wangjq.base.thread.escape;


/**
 * @author wjq
 * @since 2021-10-08
 */
public class ThisEscapeTest {
    public static void main(String[] args) {
        EventSource<EventListener> source = new EventSource<>();
        ListenerRunnable listRun = new ListenerRunnable(source);
        Thread thread = new Thread(listRun);
        thread.start();
        ThisSafe.getInstance(source);
    }
}
