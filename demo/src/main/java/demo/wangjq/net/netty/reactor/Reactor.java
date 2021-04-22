package demo.wangjq.net.netty.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * @author wang, jinqiao
 * @date 22/04/2021
 */
public class Reactor implements Runnable {


    final static int PORT = 9999;

    public static void main(String[] args) {
        try {
            Reactor  reactor = new Reactor();
            new Thread(reactor).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    Selector selector;

    ServerSocketChannel serverSocketChannel;

    public Reactor() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        selector = Selector.open();
        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        register.attach(new AcceptorHandler(serverSocketChannel, selector));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey next : selectionKeys) {
                    dispatch(next);
                }
                selectionKeys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void dispatch(SelectionKey selectionKey) {

        Runnable runnable = (Runnable) selectionKey.attachment();
        if (runnable != null) {
            runnable.run();
        }
    }
}
