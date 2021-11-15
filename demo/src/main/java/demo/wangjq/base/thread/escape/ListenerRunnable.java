package demo.wangjq.base.thread.escape;


import java.util.List;

/**
 * @author wjq
 * @since 2021-10-08
 */
public class ListenerRunnable implements Runnable {

    private EventSource<EventListener> source;

    public ListenerRunnable(EventSource<EventListener> source) {
        this.source = source;
    }

    @Override
    public void run() {
        List<EventListener> listeners = null;

        try {
            listeners = this.source.retrieveListeners();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (EventListener listener : listeners) {
            listener.onEvent(new Object());
        }
    }
}

