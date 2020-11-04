package demo.wangjq.base.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jinqwang
 */
public class SocketClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 9999;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        new Thread(() -> {
            // 与服务端建立连接
            Socket socket = null;
            try {
                socket = new Socket(host, port);
                // 建立连接后获得输出流
                OutputStream outputStream = socket.getOutputStream();
                String message = "你好  yiwangzhibujian";
                //System.out.println(outputStream == outputStream1);
                outputStream.write(message.getBytes("UTF-8"));
                Thread.sleep(1000);
                outputStream.write(message.getBytes("UTF-8"));
                socket.getInputStream().read();
                outputStream.close();
                socket.close();
                System.out.println("发送成功");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("结束");
            }
        }).start();
        //Thread.currentThread().join();
        Thread.sleep(1000);
    }
}
