package demo.wangjq.excel;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import demo.wangjq.excel.easyexcel.Area;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wang, jinqiao
 * @title: ExcelToJson
 * @date 17/02/2020
 */
public class ExcelToJsonTest {

    public static final String PATH = "C:\\Users\\jinqwang\\Desktop\\area.xlsx";

    @Test
    public void treeToJson() {
        List<Area> areas = excelToTree();
        Area area = new Area();
        area.setId(0);
        area.setParentId(null);
        area.setChildren(areas);

        String s = JSONUtil.toJsonStr(area);
        System.out.println(s);
    }

    public List<Area> excelToTree() {

        String fileName = PATH;
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭

        List<Area> list = EasyExcel.read(fileName).head(Area.class).sheet().doReadSync();

        List<Area> areas = new ArrayList<>();
        Map<String, Area> map = new HashMap<>();

        for (Area areaTree : list) {
            map.put(String.valueOf(areaTree.getId()), areaTree);
        }
        for (Area area : list) {
            Area parent = map.get(area.getParentId().toString());
            if (parent != null) {
                if (parent.getChildren() != null) {
                    List<Area> children = parent.getChildren();
                    children.add(area);
                } else {
                    List<Area> children = new ArrayList<>();
                    children.add(area);
                    parent.setChildren(children);
                }
            } else {
                areas.add(area);
            }
        }
        return areas;
    }
}
