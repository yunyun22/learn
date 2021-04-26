package demo.wangjq.net.netty.reactor;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wang, jinqiao
 * @date 22/04/2021
 */
public class AcceptorHandler implements Runnable {


    ServerSocketChannel serverSocketChannel;

    Selector selector;

    public AcceptorHandler(ServerSocketChannel serverSocketChannel, Selector selector) {
        this.serverSocketChannel = serverSocketChannel;
        this.selector = selector;
    }

    @Override
    public void run() {
        SocketChannel channel;
        try {
            channel = serverSocketChannel.accept();
            if (channel != null) {
                new EchoHandler(selector, channel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
