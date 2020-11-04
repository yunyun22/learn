package demo.wangjq.base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jinqwang
 */
public class SocketServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        while (true) {
            System.out.println("准备接受请求");
            Socket socket = server.accept();
            new Thread(new SocketRunnable(socket)).start();

            //Thread.currentThread().join();
            //socket.close();
            //server.close();
        }
    }

    static class SocketRunnable implements Runnable {

        private Socket socket;

        public SocketRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len;
                StringBuilder sb = new StringBuilder();
                while ((len = inputStream.read(bytes)) != -1) {
                    //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                    sb.append(new String(bytes, 0, len, "UTF-8"));
                }
                System.out.println("get message from client: " + sb);
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
