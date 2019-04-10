package demo.wangjq.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.BitSet;

/**
 * Created by wangjq on 2018/8/31.
 */
public class FindNotExistNumber {


    public static void main(String[] args) {
        //writeNumber();
        System.out.println(findNotExistNumber());
    }


    public static void writeNumber() {
        File file = new File("number.txt");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            for (long i = 0L; i < 100000L; i++) {
                int writeInt = 0;
                if (i > Integer.MAX_VALUE) {
                    writeInt = Integer.MAX_VALUE;
                } else {
                    writeInt = (int) i;
                }
                System.out.println(i);
                if (writeInt != 9999) {
                    byte[] bytes = intToByteArray(writeInt);
                    outputStream.write(bytes);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static int findNotExistNumber() {
        File file = new File("number.txt");

        long[] longs = new long[100000 / 64];

        BitSet bitSet = new BitSet();

        byte[] bytes = new byte[4];

        int byteread = 0;

        try {
            InputStream inputStream = new FileInputStream(file);

            while ((byteread = inputStream.read(bytes)) != -1) {
                int temp = byteArrayToInt(bytes);
                System.out.println(temp);
                bitSet.set(temp);
            }
            System.out.println("bitset length:" + bitSet.length());

            for (int i = 0; i < bitSet.length(); i++) {
                boolean b = bitSet.get(i);
                if (!b) {
                    return i;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

}
