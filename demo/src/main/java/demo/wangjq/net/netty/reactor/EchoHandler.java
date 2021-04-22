package demo.wangjq.net.netty.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author wang, jinqiao
 * @date 22/04/2021
 */
public class EchoHandler implements Runnable {

    final SocketChannel socketChannel;

    final SelectionKey sk;

    static final int RECEIVING = 0, SENDING = 1;

    int state = 0;

    private final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


    public EchoHandler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);
        sk = socketChannel.register(selector, 0);
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        try {
            if (state == SENDING) {
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
                sk.interestOps(SelectionKey.OP_READ);
                state = RECEIVING;
            } else if (state == RECEIVING) {
                int length;
                while ((length = socketChannel.read(byteBuffer)) > 0) {
                    System.out.println(new String(byteBuffer.array(), 0, length));
                    byteBuffer.flip();
                    sk.interestOps(SelectionKey.OP_WRITE);
                    state=SENDING;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            sk.cancel();

        }
    }
}
