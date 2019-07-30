package demo.wangjq.export;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

/**
 * @author:wangjq
 * @Date: 2019/7/30 17:10
 */
public class ExcelExport {
    @Test
    public void bigDataExport() throws Exception {

        List<MsgClient> list = new ArrayList<>();
        Workbook workbook = null;
        ExportParams params = new ExportParams("计算机一班学生", "学生");
        for (int i = 0; i < 1000000; i++) {  //一百万数据量
            MsgClient client = new MsgClient();
            client.setId("1" + i);
            client.setName("wwwww" + i);
            client.setSex(1);
            list.add(client);
            if (list.size() == 10000) {
                workbook = ExcelExportUtil.exportBigExcel(params,
                        MsgClient.class, list);
                list.clear();
            }
        }
        ExcelExportUtil.closeExportBigExcel();
        File saveFile = new File("D:/excel/");
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/ExcelExportBigData.bigDataExport.xlsx");
        workbook.write(fos);
        fos.close();
    }
}
