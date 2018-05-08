package learn.wangjq.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * TestBuffer Tester.
 *
 * @author wangjq
 * @version 1.0
 * @since <pre>04/03/2018</pre>
 */
public class TestBufferTest {


    public void testTestBufferView() throws Exception {

        ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();

        byteBuffer.put(0, (byte) 0);
        byteBuffer.put(1, (byte) 'H');
        byteBuffer.put(2, (byte) 0);
        byteBuffer.put(3, (byte) 'i');
        byteBuffer.put(4, (byte) 0);
        byteBuffer.put(5, (byte) '!');
        byteBuffer.put(6, (byte) 0);

        System.out.println(byteBuffer.toString());
        System.out.println(charBuffer);
    }

    public void testByteBufferView() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);

        byteBuffer.putInt(-0257);

        byteBuffer.flip();

//        int i = byteBuffer.getInt();
//
//        System.out.println("i = " + i);


        while (byteBuffer.hasRemaining()) {

            byte b = byteBuffer.get();

            System.out.print(b);
        }


    }


} 
