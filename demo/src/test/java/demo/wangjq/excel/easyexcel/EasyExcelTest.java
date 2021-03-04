package demo.wangjq.excel.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.List;

/**
 * @author wang, jinqiao
 * @title: Test
 * @date 17/02/2020
 */
public class EasyExcelTest {


    @Test
    public void reference() {

        String sql = "INSERT INTO [dbo].[dms_template_stage_task_reference] (\n" +
                "\t[id],\n" +
                "\t[creation_date],\n" +
                "\t[created_by],\n" +
                "\t[created_by_en_name],\n" +
                "\t[created_by_name],\n" +
                "\t[del_flag],\n" +
                "\t[deleted_by],\n" +
                "\t[deletion_date],\n" +
                "\t[last_updated_by],\n" +
                "\t[last_updated_by_enname],\n" +
                "\t[last_updated_by_name],\n" +
                "\t[last_update_date],\n" +
                "\t[status],\n" +
                "\t[tenant_id],\n" +
                "\t[record_version],\n" +
                "\t[display_name],\n" +
                "\t[link],\n" +
                "\t[sort],\n" +
                "\t[stage_base_id],\n" +
                "\t[stage_task_id],\n" +
                "\t[type] \n" +
                ")\n" +
                "VALUES\n" +
                "\t(\n" +
                "\t\tNEWID(),\n" +
                "\t\t''2020-08-11 14:25:24.6633333'',\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\t''0'',\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\t''LEGAL'',\n" +
                "\t\tNULL,\n" +
                "\t\tN''{0}'',\n" +
                "\t\t''{1}'',\n" +
                "\t\t''{2}'',\n" +
                "\t\t''{3}'',\n" +
                "\t\t''{4}'',\n" +
                "\t''{5}'' \n" +
                "\t);";


        //0 display_name
        //1 link or file
        //2 sort
        //3 stage_base_id
        //4 task_id
        //5 type

        String fileName = "C:\\Users\\jinqwang\\Desktop\\link.xlsx";


        List<ToolKitReferenceDto> list = EasyExcel.read(fileName).head(ToolKitReferenceDto.class).sheet().doReadSync();


        for (ToolKitReferenceDto toolKitReferenceDto : list) {

            String link = toolKitReferenceDto.getLink();
            String reference = StringUtils.isEmpty(link) ? toolKitReferenceDto.getFileId() : link;
            String format = MessageFormat.format(sql, toolKitReferenceDto.getName(),
                    StringUtils.isEmpty(reference) ? "" : reference,
                    toolKitReferenceDto.getSort(),
                    "4FB1F9F9-B9E3-4996-916A-945DD87771B0",
                    toolKitReferenceDto.getTaskId(),
                    toolKitReferenceDto.getType());
            System.out.println(format);
        }


    }

    @Test
    public void charReplace() {
        String mic = "INSERT INTO [dbo].[dms_template_stage_task_role_function]([id], [creation_date], [created_by], [created_by_en_name], [created_by_name], [del_flag], [deleted_by], [deletion_date], [last_updated_by], [last_updated_by_enname], [last_updated_by_name], [last_update_date], [status], [tenant_id], [record_version], [func], [role], [stage_base_id], [stage_task_id]) VALUES (NEWID(), ''2020-08-04 16:20:41.1266667'', NULL, NULL, NULL, ''0'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, ''LEGAL'', NULL, ''CommentEditor;Participator'', ''MIC'', ''4FB1F9F9-B9E3-4996-916A-945DD87771B0'', ''{0}'');";
        String staff = "INSERT INTO [dbo].[dms_template_stage_task_role_function]([id], [creation_date], [created_by], [created_by_en_name], [created_by_name], [del_flag], [deleted_by], [deletion_date], [last_updated_by], [last_updated_by_enname], [last_updated_by_name], [last_update_date], [status], [tenant_id], [record_version], [func], [role], [stage_base_id], [stage_task_id]) VALUES (NEWID(), ''2020-08-04 16:20:41.1266667'', NULL, NULL, NULL, ''0'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, ''LEGAL'', NULL, ''CommentEditor;Participator'', ''Staff'', ''4FB1F9F9-B9E3-4996-916A-945DD87771B0'', ''{0}'');\n";


        String[] taskIds = new String[]{"17B23051-9A95-4027-A95D-44D6B74BBCD5",
                "219E7A8A-5306-41EA-8482-EBCAE53A08B6",
                "90AA8D8B-79EF-48E1-AA00-59F6CD46827C",
                "94A9D91E-B1C5-4C45-A529-8E4253C24147",
                "9FF2682A-4E4C-48ED-A35A-9774A27CC306",
                "CFEBC9C2-C4D5-43F0-8B2D-F7A518711F5F",
                "DF0972B6-96FA-478A-B646-F153861AA150",
                "E27C64AD-4501-4F1D-A4B1-10F9354CDCC0",
                "E6291F63-FD68-4EA3-A5A3-DF4CC399330C",
                "E97F9D03-B60C-4924-966A-74B281175A4F",
                "EF25501E-4FA3-48AC-ACE9-5A94A209DD44",
                "F0FEA00E-AC09-4CEE-9F8A-A0CFA9EDAD1A"};

        for (String taskId : taskIds) {

            String micSQL = MessageFormat.format(mic, taskId);
            System.out.println(micSQL);
            String staffSQL = MessageFormat.format(staff, taskId);
            System.out.println(staffSQL);
        }


    }


    @Test
    public void readExcel() {

        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "C:\\Users\\jinqwang\\Desktop\\task.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭


        String sql = "INSERT INTO [dbo].[dms_template_stage_task] (\n" +
                "\t[id],\n" +
                "\t[creation_date],\n" +
                "\t[created_by],\n" +
                "\t[created_by_en_name],\n" +
                "\t[created_by_name],\n" +
                "\t[del_flag],\n" +
                "\t[deleted_by],\n" +
                "\t[deletion_date],\n" +
                "\t[last_updated_by],\n" +
                "\t[last_updated_by_enname],\n" +
                "\t[last_updated_by_name],\n" +
                "\t[last_update_date],\n" +
                "\t[status],\n" +
                "\t[tenant_id],\n" +
                "\t[record_version],\n" +
                "\t[description_cn],\n" +
                "\t[description_en],\n" +
                "\t[detail_cn],\n" +
                "\t[detail_en],\n" +
                "\t[edit_complete_date],\n" +
                "\t[enable],\n" +
                "\t[progress_types],\n" +
                "\t[show_percent],\n" +
                "\t[sort],\n" +
                "\t[stage_base_id],\n" +
                "\t[stage_category_id],\n" +
                "\t[table_key],\n" +
                "\t[title_cn],\n" +
                "\t[title_en],\n" +
                "\t[upload_types],\n" +
                "\t[can_input_comment],\n" +
                "\t[note_reminder_cn],\n" +
                "\t[note_reminder_en],\n" +
                "\t[require_table_data] \n" +
                ")\n" +
                "VALUES\n" +
                "\t(\n" +
                "\t\tNEWID(),\n" +
                "\t\t''2020-08-07 19:06:19.0266667'',\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\t''0'',\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\tNULL,\n" +
                "\t\t''LEGAL'',\n" +
                "\t\tNULL,\n" +
                "\t\tN''{0}'',\n" +
                "\t\tN''{1}'',\n" +
                "\t\tN''{2}'',\n" +
                "\t\tN''{3}'',\n" +
                "\t ''1'',\n" +
                "\t ''1'',\n" +
                "\t''NA;Yes'',\n" +
                "\t''0'',\n" +
                "\t{8},\n" +
                "\t''{4}'',\n" +
                "\t''{5}'',\n" +
                "\t'''',\n" +
                "\tN''{6}'',\n" +
                "\tN''{7}'',\n" +
                "\t''LocalUpload'',\n" +
                "\t''0'',\n" +
                "\tNULL,\n" +
                "\tNULL,\n" +
                "''0'' \n" +
                ");";

        /*
         * 0description_cn
         * 1description_en
         * 2detail_cn
         * 3detail_en
         * 4stage_base_id
         * 5stage_category_id
         * 6title_cn
         * 7title_en
         * 8sort
         */

        List<ToolkitDto> list = EasyExcel.read(fileName).head(ToolkitDto.class).sheet().doReadSync();
        for (ToolkitDto toolkitDto : list) {

            String descEn = toolkitDto.getDesEn();
            if (StringUtils.hasText(descEn)) {
                descEn = descEn.replaceAll("'", "''");
                toolkitDto.setDesEn(descEn);
            }
            String detailEn = toolkitDto.getDetailEn();
            if (StringUtils.hasText(detailEn)) {
                detailEn = detailEn.replaceAll("'", "''");
                toolkitDto.setDetailEn(detailEn);
            }
            String detailCn = toolkitDto.getDetailCn();
            String dtoDetailEn = toolkitDto.getDetailEn();

            if (StringUtils.isEmpty(detailCn)) {
                toolkitDto.setDetailCn("");
            }

            if (StringUtils.isEmpty(dtoDetailEn)) {
                toolkitDto.setDetailEn("");
            }


            String format = MessageFormat.format(sql, toolkitDto.getDesCn(),
                    toolkitDto.getDesEn(),
                    toolkitDto.getDetailCn(),
                    toolkitDto.getDetailEn(),
                    toolkitDto.getBaseId(),
                    toolkitDto.getCategoryId(),
                    toolkitDto.getTitleCn(),
                    toolkitDto.getTitleEn(),
                    toolkitDto.getSort());
            System.out.println(format);
        }

    }


}
