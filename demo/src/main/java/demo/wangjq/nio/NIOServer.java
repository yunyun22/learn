package learn.wangjq.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;

public class NIOServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.socket().bind(new InetSocketAddress(10000));

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int i = selector.select();
            if (i < 1) {
                continue;
            }
            Iterator<SelectionKey> iterable = selector.selectedKeys().iterator();

            while (iterable.hasNext()) {
                SelectionKey selectionKey = iterable.next();

                selectionKey.readyOps();

                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannelTemp = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannelTemp.accept();
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }
                if(selectionKey.isReadable()){
                    ServerSocketChannel serverSocketChannelTemp = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannelTemp.accept();
                }
                iterable.remove();

            }

        }

    }
}
