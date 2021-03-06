package demo.wangjq.base.characterset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * 编码
 *
 * @author wangjq
 */
public class CharacterSetTest {

    public static void main(String[] args) {

        String s = "你好";

        //客户端编码
        Charset utf = Charset.forName("UTF-8");
        ByteBuffer encode = utf.encode(s);
        //编码完成后网络进行传输
        byte[] array = encode.array();

        //服务器解码
        Charset iso = Charset.forName("ISO-8859-1");
        CharBuffer decode1 = iso.decode(encode);

        /**
         * 程序员数据处理之前发现不对
         */
        for (char c : decode1.array()) {
            /**
             * 这里不能转为byte，iso编码范围是0-255
             * byte是有符号的，只能表示-128-127
             */
            System.out.print((int) c + "  ");
            System.out.print(c + "  ");
        }

        //程序员发现不对之后。再次使用ISO-8859-1进行编码
        ByteBuffer encode1 = iso.encode(decode1);
        //最后使用utf-8解码
        CharBuffer decode = utf.decode(encode1);

        /**
         * 结果正确
         */
        System.out.println(decode.array());

    }

}
