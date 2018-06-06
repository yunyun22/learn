package demo.wangjq.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class TestChannel {


    public static void main(String[] args) throws IOException {

//        dispersedReadAndGatherWrite("test.sql");
        ReadableByteChannel readableByteChannel = Channels.newChannel(System.in);
        System.out.println("input end");
        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);
        System.out.println("output end");
        copyChannel(readableByteChannel, writableByteChannel);
        System.out.println("copy end");
        readableByteChannel.close();
        writableByteChannel.close();
    }


    public static void copyChannel(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);

        while (readableByteChannel.read(buffer) != -1) {
            buffer.flip();
            writableByteChannel.write(buffer);
            buffer.compact();
        }

        buffer.flip();

        while (buffer.hasRemaining()) {
            writableByteChannel.write(buffer);
        }

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
