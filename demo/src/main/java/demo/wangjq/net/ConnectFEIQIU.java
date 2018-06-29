package demo.wangjq.net;

import java.io.*;
import java.net.*;

/**
 * Created by wangjq on 2018/6/22.
 */
public class ConnectFEIQIU {

    public static void main(String[] args) throws IOException {
        //飞秋的数据格式
        String str = "1:100:Jack:dell:32:hello 你好啊";
        byte[] array = str.getBytes();

        //ds.send(dp);
        int i = 0;
        while (true) {
            //发送的管道
            DatagramSocket ds = new DatagramSocket();
            //数据包
            DatagramPacket dp = new DatagramPacket(array, array.length, InetAddress.getByName("192.168.10.53"), 2425);

            i++;
            dp.setData((str + i).getBytes());
            ds.send(dp);
            System.out.println("=================");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ds.close();
        }

    }

}
