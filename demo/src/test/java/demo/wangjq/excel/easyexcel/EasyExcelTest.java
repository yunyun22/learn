package demo.wangjq.excel.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.List;

/**
 * @author wang, jinqiao
 * @title: Test
 * @date 17/02/2020
 */
public class EasyExcelTest {


    @Test
    public void readExcel() {

        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "C:\\Users\\jinqwang\\Desktop\\area.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭

        List<Area> list = EasyExcel.read(fileName).head(Area.class).sheet().doReadSync();
        for (Area data : list) {
            System.out.println(data);
        }

    }


}
