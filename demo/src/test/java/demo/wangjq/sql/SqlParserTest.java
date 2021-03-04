package demo.wangjq.sql;

import cn.hutool.core.util.StrUtil;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author wang, jinqiao
 * @date 22/01/2021
 */
public class SqlParserTest {




    @Test
    public void test() throws InstantiationException, IllegalAccessException, NoSuchFieldException {


        TestDto reflex = testReflex(TestDto.class);

        Field borrowId = TestDto.class.getDeclaredField("borrowId");

        borrowId.setAccessible(true);
        borrowId.set(reflex,"aaa");

        System.out.println(reflex);
    }

    public <T> T testReflex(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }


    public static final String QUERY = "SELECT " +
            "  pd.id AS borrowId, " +
            "  p.id, " +
            "  pd.request_no, " +
            "  p.project_name, " +
            "  p.code, " +
            "  p.client_name, " +
            "CASE " +
            "     " +
            "    WHEN his.activation = 'RETURN' THEN " +
            "    'Returned'  " +
            "    WHEN his.is_done = 0 THEN " +
            "    'To Approve'  " +
            "    WHEN his.is_done = 1 THEN " +
            "    'Approved'  " +
            "  END AS audit_status, " +
            "  his.reviewer, " +
            "  his.LAST_UPDATE_DATE, " +
            "  pd.submitted_by_en_name, " +
            "  pd.submitted_on  " +
            "FROM " +
            "  ( " +
            "  SELECT " +
            "  CASE " +
            "       " +
            "    WHEN " +
            "      h.is_done = 0 THEN " +
            "        rank () OVER ( ORDER BY h.creation_date )  " +
            "        WHEN h.is_done = 1 THEN " +
            "        rank () OVER ( ORDER BY h.creation_date ) * - 1  " +
            "      END AS 'time_sort', " +
            "      h.*  " +
            "    FROM " +
            "      ( " +
            "      SELECT DISTINCT " +
            "        t1.file_borrow_id, " +
            "        t1.is_done, " +
            "        t2.creation_date, " +
            "        t1.reviewer, " +
            "        t1.LAST_UPDATE_DATE, " +
            "        t1.activation  " +
            "      FROM " +
            "        ( " +
            "        SELECT " +
            "          h.file_borrow_id, " +
            "          h.reviewer_role_code, " +
            "          h.is_done, " +
            "          h.reviewer, " +
            "          h.LAST_UPDATE_DATE, " +
            "          h.activation  " +
            "        FROM " +
            "          ( SELECT *, ROW_NUMBER () OVER ( partition BY file_borrow_id ORDER BY is_done ) AS seq FROM dms_file_borrow_audit_history WHERE reviewer_role_code = 'a' AND DEL_FLAG = 0 ) h  " +
            "        WHERE " +
            "          h.seq = 1  " +
            "        ) t1 " +
            "        LEFT JOIN ( SELECT file_borrow_id, is_done, MAX ( creation_date ) AS creation_date FROM dms_file_borrow_audit_history WHERE del_flag = 0 GROUP BY file_borrow_id, is_done ) t2 ON t1.file_borrow_id = t2.file_borrow_id  " +
            "        AND t1.is_done = t2.is_done  " +
            "      ) h  " +
            "    ) his " +
            "    LEFT JOIN dms_file_borrow_apply pd ON his.file_borrow_id = pd.id " +
            "    LEFT JOIN dms_project p ON pd.project_id = p.id  " +
            "  WHERE " +
            "    pd.del_flag = 0  " +
            "  AND p.del_flag = 0  " +
            "  AND pd.tenant_id = p.tenant_id";


    @Test
    public void testSQL() throws NoSuchFieldException, IllegalAccessException {
        try {
            Statement statement = CCJSqlParserUtil.parse(QUERY);
            Select selectStatement = (Select) statement;
            SelectBody selectBody = selectStatement.getSelectBody();
            PlainSelect plainSelect = (PlainSelect) selectBody;
            List<SelectItem> selectItems = plainSelect.getSelectItems();
            Map<Integer,String> columnNames = new HashMap<>();

            final int[] i = {0};

            for (SelectItem selectItem : selectItems) {
                selectItem.accept(new SelectItemVisitor() {
                    @Override
                    public void visit(AllColumns allColumns) {

                    }

                    @Override
                    public void visit(AllTableColumns allTableColumns) {

                    }

                    @Override
                    public void visit(SelectExpressionItem selectExpressionItem) {
                        Alias alias1 = selectExpressionItem.getAlias();
                        if (Objects.nonNull(alias1)) {
                            System.out.println(alias1.getName());
                            columnNames.put(i[0]++, StrUtil.toCamelCase(alias1.getName()));
                        }

                        Expression expression = selectExpressionItem.getExpression();
                        if (expression instanceof Column) {
                            Column column = (Column) expression;
                            String columnName = column.getColumnName();
                            String fullyQualifiedName = column.getFullyQualifiedName();

                            System.out.println("columnName:" + columnName + ",fullyQualifiedName:" + fullyQualifiedName);
                            columnNames.put(i[0]++, StrUtil.toCamelCase(columnName));
                        }
                    }
                });
            }


            System.out.println(columnNames.values());


            Set<Integer> integers = columnNames.keySet();


            TestDto testDto = new TestDto();

            for (Integer key : integers){
                String s = columnNames.get(key);
                Field field = TestDto.class.getDeclaredField(s);
                Class<?> type = field.getType();
                //TODO 转换
                field.setAccessible(true);
                field.set(testDto,String.valueOf(key));
            }

            System.out.println(testDto);

            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
            System.out.println("table names:" + tableList);

        } catch (JSQLParserException e) {
            e.printStackTrace();
        }

    }


}
