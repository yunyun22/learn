package demo.wangjq.base.file.mysql.compact;

public class IntegerColumn implements Column {

    @Override
    public int bytes() {
        return 4;
    }

    @Override
    public Object byteToObject(byte[] data, int off) {
        int b0 = data[off] & 0xFF;
        int b1 = data[off + 1] & 0xFF;
        int b2 = data[off + 2] & 0xFF;
        int b3 = data[off + 3] & 0xFF;
        return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
    }

    @Override
    public byte[] objectToByte(Object o) {
        Integer i = (Integer) o;
        byte[] targets = new byte[4];
        targets[3] = (byte) (i & 0xFF);
        targets[2] = (byte) (i >> 8 & 0xFF);
        targets[1] = (byte) (i >> 16 & 0xFF);
        targets[0] = (byte) (i >> 24 & 0xFF);
        return targets;
    }

    @Override
    public byte[] extra() {
        return new byte[]{};
    }


}
