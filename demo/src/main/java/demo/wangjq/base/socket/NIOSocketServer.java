package demo.wangjq.base.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jinqwang
 */
public class NIOSocketServer {

    public static void main(String[] args) throws IOException {
        Selector selector = initServer();
        while (true) {
            System.out.println("开始select");
            int select = selector.select();
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                try {
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel =
                                (ServerSocketChannel) selectionKey.channel();
                        SocketChannel channel = serverSocketChannel.accept();
                        channel.configureBlocking(false);
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.register(selector, SelectionKey.OP_READ, buffer);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        buffer.clear();
                        StringBuilder sb = new StringBuilder();
                        int read = 0;
                        while ((read = channel.read(buffer)) > 0) {
                            buffer.flip();
                            sb.append(Charset.forName("UTF-8").
                                    newDecoder().decode(buffer));
                            buffer.clear();
                        }
                        System.out.printf("收到 %s 发来的：%s\n",
                                channel.getRemoteAddress(), sb);
                    }
                } catch (IOException e) {
                    selectionKey.cancel();
                    selectionKey.channel().close();
                    System.err.println(e.getMessage());
                }
                iterator.remove();
            }
        }
    }

    private static Selector initServer() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.bind(new InetSocketAddress(9999));
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server 启动");
        return selector;
    }
}
