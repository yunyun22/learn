package demo.wangjq.excel.easyexcel;

import com.alibaba.excel.EasyExcel;
import java.text.MessageFormat;
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
		String fileName = "C:\\Users\\jinqwang\\Desktop\\processTree.xlsx";
		// 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭


		String sql = "INSERT INTO \"ADMIN\".\"BASE_DLA_PROCESS_TREE\"(\"PROCESS_TREE_ID\", \"EMP_CLASS\", \"PROCESS_CLASS_ID\", \"PROCESS_NAME\", \"PROCESS_TYPE_ID\", \"SORT\", \"DESCRIPTION\", \"ACTIVE_FLAG\", \"CREATE_USER\", \"CREATE_DATE\", \"MODIFIED_USER\", \"MODIFIED_DATE\", \"IP\", \"PARENT_ID\") VALUES (''{0}'', ''{1}'', ''{2}'', ''{3}'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ''0'');";


		//0 id
		//1 empClass
		//2 PROCESS_CLASS_ID
		//3 PROCESS_NAME
		//4 PROCESS_TYPE_ID
		List<BaseDlaProcessClass> list = EasyExcel.read(fileName).head(BaseDlaProcessClass.class).sheet().doReadSync();
		int i = 1;
		for (BaseDlaProcessClass data : list) {
			String format = MessageFormat.format(sql, String.valueOf(i), data.getEmpClass(), data.getProcessClassId(), data.getProcessClassName(),data.getProcessTypeId());
			System.out.println(format);
			i++;
		}

	}


}
