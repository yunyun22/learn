package demo.wangjq.base.file.mysql.compact;

public interface Column {

    /**
     * 该列字节数
     *
     * @return 字节数
     */
    int bytes();

    Object byteToObject(byte[] data, int off);


    byte[] objectToByte(Object o);


    byte[] extra();
}
