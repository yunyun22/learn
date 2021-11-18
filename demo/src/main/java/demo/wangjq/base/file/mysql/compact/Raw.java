package demo.wangjq.base.file.mysql.compact;

public class Raw {

    private byte[] extra;

    private byte[] nul;

    private byte[] data;

    public Raw() {

    }

    public byte[] getExtra() {
        return extra;
    }

    public void setExtra(byte[] extra) {
        this.extra = extra;
    }

    public byte[] getNul() {
        return nul;
    }

    public void setNul(byte[] nul) {
        this.nul = nul;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}
