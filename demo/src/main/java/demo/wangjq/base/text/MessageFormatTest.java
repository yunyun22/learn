package demo.wangjq.base.text;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wang, jinqiao
 * @title: MessageFormatTest
 * @date 17/06/2021
 */
public class MessageFormatTest {

    public static void main(String[] args) {
        List<String>  deleteList = Arrays.asList("1","2","3");

        List<String> collect = deleteList.stream().map(s -> "'" + s + "'").collect(Collectors.toList());
        String sql = "delete from dms_data_right  where project_id in({0}) and staff_no =:staffNo and tenant_id =:tenantId ";
        HashMap<String, Object> map = Maps.newHashMap();

        sql = MessageFormat.format(sql, StringUtils.join(collect, ","));
        System.out.println(sql);

    }
}
