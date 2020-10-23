package demo.wangjq.text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


    public static final String messageSQL = "INSERT INTO [dbo].[dms_msg_message]([id], [creation_date], [created_by], [created_by_en_name], [created_by_name], [del_flag], [deleted_by], [deletion_date], [last_updated_by], [last_updated_by_enname], [last_updated_by_name], [last_update_date], [status], [tenant_id], [record_version], [message], [parent_id], [send_time], [send_user_cname], [send_user_email], [send_user_ename], [send_user_staff_no], [send_username], [sequence_no], [topic_id]) " +
            "VALUES (newId(), '2020-08-08 11:54:52.2880000', '-1', 'SYSTEM', N'SYSTEM', '0', NULL, NULL, '-1', 'SYSTEM', N'SYSTEM', '2020-08-08 11:54:52.2880000', NULL, 'FA', 1, N%s, NULL, '2020-08-08 11:54:52.2880000', N'summerFA01Staff3', 'summerhwang@deloitte.com.cn', 'summerFA01 Staff 3', '400302', N'summerFA01Staff3', %d, 'fbfc5672-129f-49f7-a8e7-9c3c275c68af');\n";


    public static final String getMessageSQL1 = "INSERT INTO [dbo].[dms_msg_message_copy1]([id], [creation_date], [created_by], [created_by_en_name], [created_by_name], [del_flag], [deleted_by], [deletion_date], [last_updated_by], [last_updated_by_enname], [last_updated_by_name], [last_update_date], [status], [tenant_id], [record_version], [message], [parent_id], [send_time], [send_user_cname], [send_user_email], [send_user_ename], [send_user_staff_no], [send_username], [sequence_no], [topic_id]) " +
            "VALUES (%d, '2020-08-08 11:54:52.2880000' ,'-1', 'SYSTEM', N'SYSTEM', '0', NULL, NULL, '-1', 'SYSTEM', N'SYSTEM', '2020-08-08 13:58:36.5610000', NULL, 'FA', 1, N%s, NULL, '2020-08-08 13:58:36.5610000', N'马云燕', 'receiver@ges.deloitte.com.cn', 'Yun Yan Grace Ma', '105253', 'gma', %d, '1a2dd649-98e0-4462-bd17-e95d0e14a785');\n";

    public static void main(String[] args) {
        try {
            // 相对路径，如果没有则要建立一个新的output.txt文件
            File writeName = new File("C:\\Users\\jinqwang\\message.sql");
            boolean newFile = writeName.createNewFile();
            // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                for (int i = 0; i < 100000; i++) {
                    String format = String.format(getMessageSQL1, i, "'测试大量的消息" + (i + 5) + "'", 5 + i);
                    //String format = MessageFormat.format(messageSQL, "'测试大量的消息" + i + "'", String.valueOf(16 + i));
                    out.write(format);
                }
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 写入TXT文件
     */
    public static void writeFile(File file) {
        try {
            // 相对路径，如果没有则要建立一个新的output.txt文件
            File writeName = new File("output.txt");
            // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                // 把缓存区内容压入文件
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
