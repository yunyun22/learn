package learn.wangjq.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class MyCopyFile {

    public static void main(String[] args) {

        //System.out.println(Thread.currentThread().getContextClassLoader().getResource("//").getPath());
        //String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        copyFile("1.jpg", "2.jpg");
    }

    /**
     * file copy
     *
     * @param sourceFileName
     * @param targetFileName
     */
    public static void copyFile(String sourceFileName, String targetFileName) {
        try {
            FileChannel inFileChannel = FileChannel.open(Paths.get(sourceFileName), READ);
            FileChannel outFileChannel = FileChannel.open(Paths.get(targetFileName), READ, WRITE, CREATE_NEW);

            MappedByteBuffer inMappedByteBuffer = inFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inFileChannel.size());
            MappedByteBuffer outMappedByteBuffer = outFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, inFileChannel.size());

            byte[] bytes = new byte[inMappedByteBuffer.limit()];
            inMappedByteBuffer.get(bytes);
            outMappedByteBuffer.put(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * file copy
     *
     * @param sourceFileName
     * @param targetFileName
     */
    public static void copyFile2(String sourceFileName, String targetFileName) {
        try {
            FileInputStream inputStream = new FileInputStream(sourceFileName);
            FileInputStream outputStream = new FileInputStream(targetFileName);

            FileChannel inputFileChannel = inputStream.getChannel();
            FileChannel outputFileChannel = outputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (inputFileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outputFileChannel.write(byteBuffer);
                byteBuffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

    /**
     * file copy
     *
     * @param sourceFileName
     * @param targetFileName
     */
    public static void copyFile3(String sourceFileName, String targetFileName) throws IOException {
        FileChannel inFileChannel = FileChannel.open(Paths.get(sourceFileName), READ);
        FileChannel outFileChannel = FileChannel.open(Paths.get(targetFileName), READ, WRITE, CREATE_NEW);

        inFileChannel.transferTo(0, inFileChannel.size(), outFileChannel);

        inFileChannel.close();
        outFileChannel.close();

    }

}
