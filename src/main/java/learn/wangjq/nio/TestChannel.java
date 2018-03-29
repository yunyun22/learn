package learn.wangjq.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannel {


    public static void main(String[] args) {
        dispersedReadAndGatherWrite("test.sql");
    }


    public static void dispersedReadAndGatherWrite(String filePath) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");

            FileChannel fileChannel = randomAccessFile.getChannel();

            ByteBuffer byteBuffer1 = ByteBuffer.allocate(100);

            ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);

            ByteBuffer[] byteBuffers = new ByteBuffer[]{byteBuffer1, byteBuffer2};

            fileChannel.read(byteBuffers);

            for (ByteBuffer byteBuffer :
                    byteBuffers) {
                byteBuffer.flip();
            }

            System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit()));

            System.out.println("--------------");

            System.out.println(new String(byteBuffers[1].array(), 0, byteBuffers[1].limit()));

            RandomAccessFile randomAccessFile1 = new RandomAccessFile("test.txt", "rw");

            FileChannel fileChannel1 = randomAccessFile1.getChannel();

            fileChannel1.write(byteBuffers);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
