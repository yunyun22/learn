package demo.wangjq.base.file.mysql.compact;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class Table {

    private Column[] columns;

    private List<Raw> raws;

    public Table(Column[] columns) {
        this.columns = columns;
        this.raws = new ArrayList<>();
    }

    public Column[] getColumns() {
        return this.columns;
    }

    public void write(Object[] data) {
        if (data.length != columns.length) {
            throw new RuntimeException("定义列与传入数据的数量不一致");
        }
        int i = 0;
        byte[] bytes = new byte[getBytes()];
        int destPos = 0;
        for (Column column : columns) {
            if (column instanceof IntegerColumn) {
                Integer datum = (Integer) data[i];
                System.arraycopy(column.objectToByte(datum), 0, bytes, destPos, column.bytes());
            }
            destPos += column.bytes();
            i++;
        }
        Raw raw = new Raw();
        raw.setData(bytes);
        raws.add(raw);
    }


    public Object[] read(int i) {
        if (i >= raws.size()) {
            throw new IllegalArgumentException("i should less more bytes");
        }
        Object[] result = new Object[columns.length];

        Raw raw = raws.get(i);
        byte[] data = raw.getData();
        int pos = 0;
        for (Column column : columns) {
            Object o = column.byteToObject(data, pos);
            result[i++] = o;
            pos += column.bytes();

        }
        return result;
    }


    private int getBytes() {
        int size = 0;
        for (Column column : columns) {
            size += column.bytes();
        }
        return size;
    }

}
