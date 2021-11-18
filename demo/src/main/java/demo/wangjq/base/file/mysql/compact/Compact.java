package demo.wangjq.base.file.mysql.compact;

import cn.hutool.core.util.ArrayUtil;


public class Compact {


    public static void main(String[] args) {

        IntegerColumn column = new IntegerColumn();
        Table table = new Table(new IntegerColumn[]{column, column, column});

        Integer[] data = new Integer[]{1, 2, 3};
        table.write(data);

        Object[] read = table.read(0);

        System.out.println(ArrayUtil.toString(read));

    }
}
