package demo.wangjq.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServe {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(20000);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            String info = null;
            System.out.println("starting");
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + info);
                pw.println("欢迎您！");
            }
        }
    }
}
