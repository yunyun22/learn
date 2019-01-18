package demo.wangjq.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServe {

    //private static List<Socket> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(20000);
        while (true) {
            Socket socket = serverSocket.accept();
            //list.add(socket);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            String info = null;
            System.out.println("starting");
            /**
             * 不断接受信息，并返回信息
             */
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + info);
                pw.println("欢迎您！");
                pw.flush();
            }
        }
    }
}
