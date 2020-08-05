package demo.wangjq.text;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class GenerateSQL {


    public static final String sql = "INSERT INTO []([ID], [DICT_ID], [VALUE_], [LABEL_], [TYPE_], [DESCRIPTION], [SORT_ORDER], [REMARKS], [DEL_FLAG], [TENANT_ID], [CREATION_DATE], [CREATED_BY], [CREATED_BY_EN_NAME], [CREATED_BY_NAME], [DELETED_BY], [DELETION_DATE], [LAST_UPDATED_BY], [LAST_UPDATED_BY_ENNAME], [LAST_UPDATED_BY_NAME], [LAST_UPDATE_DATE], [STATUS], [RECORD_VERSION]) " +
            "VALUES (UUI(), 'B0233B7B-7236-4084-88B0-44D0AE9D2080', {0}, {0}, 'digital_asset', N{0}, {1}, NULL, '0', 'FA', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";


    public static final List<String> list = Arrays.asList("'CN FA Asset_ValueD'",
            "'CN FA Asset_Model+'",
            "'CN FA Asset_Automated Valuation Statutory Report'",
            "'CN FA Asset_iDeal'",
            "'CN FA Asset_CIP-FA'",
            "'CN FA Asset_M&A Deals Database'",
            "'CN FA Asset_IRA-AML'",
            "'CN FA Asset_E-Discovery'",
            "'CN FA Asset_DI-AML'");

    public static void main(String[] args) {
        int i = 1;
        for (String key : list) {
            System.out.println(MessageFormat.format(sql, key, String.valueOf(i++)));
        }

    }
}
