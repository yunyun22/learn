package demo.wangjq.base.excel;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wang, jinqiao
 * @title: GenerateSqlForProjectCode
 * @date 09/01/2020
 */
public class GenerateSqlForProjectCodeTest {

    public String sql = "INSERT INTO tr_project(" +
            "id, DEL_FLAG, TENANT_ID,cea_no, client_code, " +//1
            "client_name,engagement_code, contract_c, fisy,mic, pic, isSoe,\n" +//2
            "pic_name, mic_name, opportunity_id,\n" +//3
            "opportunity_name,opportunity_source, is_contingent_basis,\n" +//4
            "profit_ctr, engagement_desc, open_code_date,\n" +//5
            "start_date, close_date, location,\n" +//6
            "lcsp, region_code, service_offering,\n" +//7
            "service_offering_desc, func_service_line, scope_of_service,\n" +//8
            "est_Fee, eng_letter_no, is_recurring,engagement_risk,\n" +//9
            "confidentiality_risk, industry_code, industry,dtt_relationship,\n" +//10
            "client_risk, type_of_client, nature_of_business,\n" +//11
            "master_code, cea_status, service_item_team_member,\n" +//12
            "cea_approval_date, primary_address, city,\n" +//13
            "year_end_month,business_registration_no, country, province)\n" +//14
            "\tVALUES(NEWID(), 0, 'FA', '%s', '%s', " +//1
            "'%s', '%s', 'US', '2020', '%s', '%s', 'true',\n" +//2
            "\t'%s', '%s', '3000001017', \n" +//3
            " 'Project Channel', 'Existing client', 'No',\n" +//4
            " '314060', 'HK7M171-Sundry of Mark OReilly','2019-01-15', \n" +//5
            " '2018-08-24', '2019-07-31', 'BJ',  \n" +//6
            " '911007', 'SCHK', 'FVM', \n" +//7
            " 'V&M TVA-CORP DEVELOP SERVICES', 'FAS', '',\n" +//8
            " 234000.00, 'EL16HKFAS0081', 'Y', 'Normal', " +//9
            " 'Normal', 'FZZ0', 'Financial Services Industry', 'No', " +//10
            " 'Normal', 'Corporation', 'Private Equity'," +//11
            " '1000010-0009-00-00-A01', 'Approved', ''," +//12
            " '2017-03-18', '19th Floor, Room 1906-10,', NULL, " +//13
            " '05',  '17876579-000', 'HK', 'HK');";//14
    //cea_no
    //client_code
    //client_name
    //code
    //mic
    //pic
    //mic_name
    //pic_name
    String ceaNoInit = "021-052";
    String clientCodeInit = "1000052";
    String clientNameInit = "TT12";
    String code = "MIC001-123";
    String mic = "100125";
    String pic = "100225";
    String micName = "MIC 25";
    String picName = "PIC 25";

    @Test
    public void generateProjectCode() {

        for (int i = 1; i < 10; i++) {

            System.out.println(String.format(sql, ceaNoInit + i, clientCodeInit + i, clientNameInit + i, ceaNoInit + i, mic, pic, micName, picName));

        }

    }


    @Test
    public void generateProjectCodeByExcel() {
        List<Map<Integer, Object>> excel = GenerateSqlTest.readExcelToObj("C:\\Users\\jinqwang\\Desktop\\UAT2.xlsx");
        //System.out.println(excel);


        List<Map<Integer, Object>> collect = excel.stream()
                .filter(integerObjectMap -> Objects.equals(integerObjectMap.get(0), "MIC") || Objects.equals(integerObjectMap.get(0), "PIC"))
                .collect(Collectors.toList());

        //System.out.println(collect);

        int k = 1;

        for (int j = 0; j < collect.size(); ) {
            Map<Integer, Object> mic = collect.get(j++);
            Map<Integer, Object> pic = collect.get(j++);
            // System.out.println(mic.get(1) + "   " + mic.get(2));
            // System.out.println(pic.get(1) + "   " + pic.get(2));
            for (int i = 1; i < 6; i++) {
                System.out.println(String.format(sql, ceaNoInit + k,
                        clientCodeInit + k, clientNameInit + k, ceaNoInit + k,
                        mic.get(2), pic.get(2), mic.get(1), pic.get(1)));
                k++;
            }
        }
        System.out.println("end============k:" + k);
    }
}
