package demo.wangjq.base.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import static jodd.util.ThreadUtil.sleep;

/**
 * @author jinqwang
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 9999;
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        System.out.println(outputStream.getClass());
        int i = 0;
        while (true) {
            SocketAddress localSocketAddress = socket.getLocalSocketAddress();
            InetSocketAddress inetSocketAddress = (InetSocketAddress) localSocketAddress;
            String message = inetSocketAddress.getPort() + "发送消息:第" + i + "次发送消息，你好";
            outputStream.write(message.getBytes("UTF-8"));
            outputStream.flush();
            System.out.println("第" + i + "发送消息完成");
            i++;
            sleep(10000);
        }
    }
}
