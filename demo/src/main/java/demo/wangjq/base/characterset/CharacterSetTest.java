package demo.wangjq.base.characterset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

public class CharacterSetTest {


    public static void main(String[] args) {


        String s = "你";


        //客户端编码
        Charset utf = Charset.forName("UTF-8");
        ByteBuffer encode = utf.encode(s);
        //编码完成后网络传输
        byte[] array = encode.array();

        //服务器解码
        Charset iso = Charset.forName("ISO-8859-1");
        CharBuffer decode1 = iso.decode(encode);


        for (char c : decode1.array()) {
            System.out.println((byte) c);
            System.out.print(c + "  ");
        }


        //程序员发现不对。再次使用ISO-8859-1进行编码
        ByteBuffer encode1 = iso.encode(decode1);
        //最后使用utf-8解码
        CharBuffer decode = utf.decode(encode1);

        System.out.println(decode.array());


    }

}
