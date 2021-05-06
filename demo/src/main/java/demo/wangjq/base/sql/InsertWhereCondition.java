package demo.wangjq.base.sql;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;

import java.io.StringReader;
import java.util.List;

/**
 * @author wang, jinqiao
 * @date 06/05/2021
 */
public class InsertWhereCondition {

    public static void main(String[] args) throws JSQLParserException {

        String sql = "SELECT *,(SELECT 1 FROM TEST t4) FROM TEST t0" +
                " left join (SELECT * FROM TEST t1) t1 ON t0.id = t1.id" +
                " left join (SELECT * FROM TEST t2) t2" +
                " WHERE 1=1";


        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        StringReader stringReader = new StringReader(sql);
        Select select = (Select) parserManager.parse(stringReader);


        SelectBody selectBody = select.getSelectBody();
        String tableName = "TEST";
        if (StrUtil.isEmpty(tableName) && selectBody instanceof PlainSelect) {
            tableName = getTableName(selectBody);
        }

        processSelectBody(selectBody, tableName);
        System.out.println(selectBody.toString());
    }

    public static void processSelectBody(SelectBody selectBody, String tableName) throws JSQLParserException {
        if (selectBody instanceof PlainSelect) {
            parsPlainSelect(selectBody, tableName);
        } else if (selectBody instanceof WithItem) {
            WithItem withItem = (WithItem) selectBody;
            if (withItem.getSelectBody() != null) {
                processSelectBody(withItem.getSelectBody(), tableName);
            }
        } else {
            SetOperationList operationList = (SetOperationList) selectBody;
            List<SelectBody> selects = operationList.getSelects();
            for (SelectBody select : selects) {
                processSelectBody(select, tableName);
            }
        }
    }

    public static void parsPlainSelect(SelectBody selectBody, String tableName) throws JSQLParserException {
        PlainSelect plain = (PlainSelect) selectBody;
        List<SelectItem> selectItems = plain.getSelectItems();
        for (SelectItem selectItem : selectItems) {
            if (selectItem instanceof SelectExpressionItem) {
                //TODO 需要解析子查询中的数据
                //SelectExpressionItem selectExpressionItem = (SelectExpressionItem) selectItem;

            }
        }
        FromItem fromItem = plain.getFromItem();
        if (buildIfNecessary(fromItem, tableName)) {
            buildWhereCondition(fromItem, plain);
        }
        List<Join> joinList = plain.getJoins();
        if (CollUtil.isNotEmpty(joinList)) {
            for (Join join : joinList) {
                if (buildIfNecessary(join.getRightItem(), tableName)) {
                    buildOnCondition(join);
                }
            }
        }
    }

    public static boolean buildIfNecessary(FromItem fromItem, String tableName) throws JSQLParserException {
        String fromItemName = null;
        if (fromItem instanceof Table) {
            fromItemName = ((Table) fromItem).getName();
        }
        if (fromItem instanceof SubSelect) {
            SelectBody subSelectBody = ((SubSelect) fromItem).getSelectBody();
            processSelectBody(subSelectBody, tableName);
        }
        if (fromItemName == null || tableName == null) {
            return false;
        }
        return fromItemName.toUpperCase().equals(tableName.toUpperCase());
    }

    public static String getTableName(SelectBody selectBody) {
        PlainSelect pain = (PlainSelect) selectBody;
        FromItem fromItem = pain.getFromItem();
        return getTableName(fromItem);
    }

    public static String getTableName(FromItem fromItem) {
        String fromItemName = null;
        if (fromItem instanceof Table) {
            fromItemName = ((Table) fromItem).getName();
        }
        if (fromItemName == null) {
            throw new IllegalArgumentException("无法获取tableName");
        }
        return fromItem.getAlias() == null ? fromItemName : fromItem.getAlias().getName();
    }

    public static void buildOnCondition(Join join) throws JSQLParserException {
        FromItem rightItem = join.getRightItem();
        String dataAuthSql = " " + getTableName(rightItem) + ".version = 1";
        if (StrUtil.isNotEmpty(dataAuthSql)) {
            if (join.getOnExpression() == null) {
                join.setOnExpression(CCJSqlParserUtil.parseCondExpression(dataAuthSql));
            } else {
                join.setOnExpression((new AndExpression(join.getOnExpression(), CCJSqlParserUtil.parseCondExpression(dataAuthSql))));
            }
        }
    }


    public static void buildWhereCondition(FromItem fromItem, PlainSelect plain) throws JSQLParserException {
        String dataAuthSql = " " + getTableName(fromItem) + ".version = 1";
        if (StrUtil.isNotEmpty(dataAuthSql)) {
            if (plain.getWhere() == null) {
                plain.setWhere(CCJSqlParserUtil.parseCondExpression(dataAuthSql));
            } else {
                plain.setWhere(new AndExpression(plain.getWhere(), CCJSqlParserUtil.parseCondExpression(dataAuthSql)));
            }
        }
    }
}