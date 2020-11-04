package demo.wangjq;

import java.text.MessageFormat;

public class SqlTest {


	public static void main(String[] args) {

		String sql = "INSERT INTO \"ADMIN\".\"BASE_DLA_PROCESS_SET_EMP\"(\"EMP_PROCESS_SET_ID\", \"EMP_CLASS\", \"PROCESS_CLASS_ID\", \"DESCRIPTION\", \"ACTIVE_FLAG\", \"CREATE_USER\", \"CREATE_DATE\", \"MODIFIED_USER\", \"MODIFIED_DATE\", \"IP\") VALUES (''{0}'', ''LABOR_DISPATCH'', ''{1}'', NULL, NULL, NULL, NULL, NULL, NULL, NULL);";

		String[] array = new String[]{
				"30013",
				"30014",
				"30015",
				"30016",
				"30017",
				"30018",
				"30019",
				"30020",
				"30007",
				"30022",
				"30024"

			};

		int i = 15;
		for (String s : array) {
			i++;
			String format = MessageFormat.format(sql, String.valueOf(i), s);
			System.out.println(format);
		}


	}
}
