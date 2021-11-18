package demo.wangjq.base.file.mysql.compact;

import java.nio.charset.Charset;

public class VarcharColumn implements Column {

    private int size;

    private byte[] extra;

    private Charset charset;

    private int bytes;

    public VarcharColumn(int size, Charset charset) {
        this.size = size;
        this.charset = charset;
    }

    public int size() {
        return size;
    }

    @Override
    public int bytes() {

        return bytes;
    }

    @Override
    public Object byteToObject(byte[] data, int off) {
        return new String(data, off, extra[0], charset);
    }

    @Override
    public byte[] objectToByte(Object o) {
        String s = (String) o;
        if (s.length() > size) {
            throw new IllegalArgumentException("参数不合法");
        }
        return s.getBytes(charset);
    }

    @Override
    public byte[] extra() {
        return extra;
    }
}
