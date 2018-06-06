package demo.wangjq.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class TestBuffer {

    public void testBufferView () {

        ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();

        byteBuffer.put(0, (byte) 0);
        byteBuffer.put(1, (byte) 'H');
        byteBuffer.put(2, (byte) 0);
        byteBuffer.put(3, (byte) 'i');
        byteBuffer.put(4, (byte) 0);
        byteBuffer.put(5, (byte) '!');
        byteBuffer.put(6, (byte) 0);

        System.out.println(byteBuffer);
        System.out.println(charBuffer);

    }

    public static void main(String[] args) {

        CharBuffer buffer = CharBuffer.allocate(100);

        String s = "hello world";

        if (fillBuffer(s, buffer)) {
            buffer.flip();
//            char[] chars = new char[buffer.limit()];
//            buffer.get(chars);
//            System.out.println(new String(chars));
            drainBuffer(buffer);
        }

    }

    private static boolean drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            char c = buffer.get();
            System.out.print(c);
        }
        return true;
    }

    private static boolean fillBuffer(String strings, CharBuffer buffer) {
        if (strings.length() > buffer.remaining()) {
            return false;
        }

        for (char c :
                strings.toCharArray()) {
            buffer.put(c);
        }
        return true;
    }

}
