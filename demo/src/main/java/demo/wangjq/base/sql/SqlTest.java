package demo.wangjq.base.sql;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.ExpressionVisitorAdapter;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

/**
 * @author wang, jinqiao
 * @date 30/04/2021
 */
public class SqlTest {


    public static void main(String[] args) throws JSQLParserException {

        String sql = " select * from a1 as a inner join b1 as b on a.id= b.id";

        Statement statement = null;

        try {
            statement = CCJSqlParserUtil.parse(sql);
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }

        Select selectStatement = (Select) statement;
        SelectBody selectBody = selectStatement.getSelectBody();

        selectBody.accept(new BdhSelectVisitor());

        System.out.println("aa");


    }

    static class BdhSelectVisitor extends SelectVisitorAdapter {

        @Override
        public void visit(PlainSelect plainSelect) {
            FromItem fromItem = plainSelect.getFromItem();
            Alias alias = fromItem.getAlias();
            List<Join> joins = plainSelect.getJoins();
            ExpressionVisitorAdapter expressionVisitorAdapter = new ExpressionVisitorAdapter() {
                @Override
                public void visit(Addition expr) {

                    String stringExpression = expr.getStringExpression();
                    System.out.println(stringExpression);
                }
            };
            for (Join join : joins) {
                join.getOnExpression().accept(expressionVisitorAdapter);
            }

           plainSelect.getWhere().accept(expressionVisitorAdapter);
        }
    }
}
