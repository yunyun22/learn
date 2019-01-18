package demo.wangjq.socket;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 20000);
        /**
         * 不断接受服务器的数据
         */
        new Thread(() -> {
            while (true) {
                try {
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String info = null;
                    while ((info = br.readLine()) != null) {
                        System.out.println("我是客户端，服务器说：" + info);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        /**
         *不断向服务器发送信息
         */
        new Thread(() -> {
            OutputStream os = null;
            BufferedReader in = null;
            try {
                os = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(os, true);//将输出流包装成打印流
            while (true) {
                pw.println("我是王金桥");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        /**
         * 将main线程睡眠
         */
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
