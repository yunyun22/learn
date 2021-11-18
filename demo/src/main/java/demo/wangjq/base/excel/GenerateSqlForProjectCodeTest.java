package demo.wangjq.base.excel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
            "year_end_month,business_registration_no, country, province, ppic1, ppic1_name, company_code,rc_code,is_master_eng,concurring_partner,concurring_partner_name)\n" +//14
            "\tVALUES(NEWID(), 0, 'FA', '%s', '%s', " +//1
            "'%s', '%s', 'US', '2020', '%s', '%s', 'true',\n" +//2
            "\t'%s', '%s', '3000001017', \n" +//3
            " 'Project Channel', 'Existing client', 'No',\n" +//4
            " '314060', 'HK7M171-Sundry of Mark OReilly','2019-01-15', \n" +//5
            " '2018-08-24', '2019-07-31', '%s',  \n" +//6
            " '911007', '%s', 'FVM', \n" +//7
            " 'V&M TVA-CORP DEVELOP SERVICES', 'FAS', '',\n" +//8
            " 234000.00, 'EL16HKFAS0081', 'Y', 'Normal', " +//9
            " '%s', 'FZZ0', 'Financial Services Industry', 'No', " +//10
            " 'Normal', 'Corporation', 'Private Equity'," +//11
            " '1000010-0009-00-00-A01', 'Approved', ''," +//12
            " '2017-03-18', '19th Floor, Room 1906-10,', NULL, " +//13
            " '05',  '17876579-000', 'HK', 'HK','%s','%s','%s','%s','%s','%s','%s');";//14
    //cea_no
    //client_code
    //client_name
    //code
    //mic
    //pic
    //mic_name
    //pic_name
    //location_code
    //region_code
    //confidentiality_risk
    //ppic
    //ppic_name
    //company_code
    //rc_code
    //is_master_eng
    //concurring_partner
    //concurring_partner_name
    String ceaNoInit = "022-952";
    String clientCodeInit = "1120052";
    String clientNameInit = "GG12";
    String code = "MIC001-123";
    String mic = "100125";
    String pic = "100225";
    String micName = "MIC 25";
    String picName = "PIC 25";
    String ppic1 = "";
    String ppicName = "";

    @Test
    public void generateProjectCode() {

        for (int i = 1; i < 10; i++) {

            System.out.println(String.format(sql,
                    ceaNoInit + i, clientCodeInit + i, clientNameInit + i,
                    ceaNoInit + i,
                    mic, pic, micName, picName));

        }

    }


    @Test
    public void generateProjectCodeByExcel() {
        //List<Map<Integer, Object>> excel = GenerateSqlTest.readExcelToObj("C:\\Users\\jinqwang\\Desktop\\UAT2.xlsx");
        //System.out.println(excel);


//        List<Map<Integer, Object>> collect = excel.stream()
//                .filter(integerObjectMap -> Objects.equals(integerObjectMap.get(0), "MIC") || Objects.equals(integerObjectMap.get(0), "PIC"))
//                .collect(Collectors.toList());
//
//        //System.out.println(collect);
//
//        int k = 1;
//
//        for (int j = 0; j < collect.bytes(); ) {
//            Map<Integer, Object> mic = collect.get(j++);
//            Map<Integer, Object> pic = collect.get(j++);
//            // System.out.println(mic.get(1) + "   " + mic.get(2));
//            // System.out.println(pic.get(1) + "   " + pic.get(2));
//            for (int i = 1; i < 6; i++) {
//                System.out.println(String.format(sql, ceaNoInit + k,
//                        clientCodeInit + k, clientNameInit + k, ceaNoInit + k,
//                        mic.get(2), pic.get(2), mic.get(1), pic.get(1)));
//                k++;
//            }
//        }
//        System.out.println("end============k:" + k);
        List<Info> list = new ArrayList<>(4);

        Info info1 = new Info("103473", "He River Huang", "104386", "Jingru Jocelyn Jiang", "102453", "Qian Qian Lulu Wu", "102790", "Wing Yi Tiffany Chan", "CQ3A", "High", "WC", "CQ", "CQ33110080", "Y","","");
        Info info2 = new Info("103971", "Ohwen Yong", "104549", "Nan Simon Zong", "102453", "Qian Qian Lulu Wu", "103292", "Hancheng Levi Yu", "BJXA", "Normal", "NC", "BJ", "BJ33N00020", "Y","","");
        Info info3 = new Info("104132", "HKin Lok Michael Wong", "104553", "Ganlin Leo Zhang", "102500", "Lin Cecilia Yang", "102790", "Wing Yi Tiffany Chan", "1FX", "Medium", "NC", "BJ", "BJX3140020", "Y","","");
        Info info4 = new Info("104681", "Kin Lok Michael Wong", "104798", "Zhaojun Nathan Yuan", "102500", "Lin Cecilia Yang", "103292", "Hancheng Levi Yu", "HK3A", "", "SCHK", "HK", "HK11163060", "Y","","");
        list.add(info1);
        list.add(info2);
        list.add(info3);
        list.add(info4);


        //cea_no
        //client_code
        //client_name
        //code
        //mic
        //pic
        //mic_name
        //pic_name
        //location_code
        //region_code
        //confidentiality_risk
        //ppic
        //ppic_name
        //company_code
        //rc_code
        //is_master_eng
        //concurring_partner
        //concurring_partner_name
        int k = 1;
        for (Info info : list) {
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format(sql, ceaNoInit + k,
                        clientCodeInit + k, clientNameInit + k, ceaNoInit + k,
                        info.getMic(), info.getPic(), info.getMicName(), info.getPicName(),
                        info.getLocationCode(), info.getRegionCode(), info.getConfidentialRisk(),
                        info.getPpic1(), info.getPpicName(), info.getCompanyCode(), info.getRcCode(), info.getIsMasterEng(), info.getCpic(),info.getCpicName()));
                k++;
            }

        }


    }

    static class Info {
        private String mic;
        private String micName;
        private String pic;
        private String picName;
        private String ppic1;
        private String ppicName;
        private String cpic;
        private String cpicName;
        private String companyCode;
        private String confidentialRisk;
        private String regionCode;
        private String locationCode;
        private String rcCode;
        private String isMasterEng;
        private String concurringPartner;
        private String concurringPartnerName;


        public Info(String mic, String micName, String pic, String picName,
                    String ppic1, String ppicName, String cpic, String cpicName,
                    String companyCode, String confidentialRisk, String regionCode,
                    String locationCode, String rcCode, String isMasterEng, String concurringPartner, String concurringPartnerName) {
            this.mic = mic;
            this.micName = micName;
            this.pic = pic;
            this.picName = picName;
            this.ppic1 = ppic1;
            this.ppicName = ppicName;
            this.cpic = cpic;
            this.cpicName = cpicName;
            this.companyCode = companyCode;
            this.confidentialRisk = confidentialRisk;
            this.regionCode = regionCode;
            this.locationCode = locationCode;
            this.rcCode = rcCode;
            this.isMasterEng = isMasterEng;
            this.concurringPartner = concurringPartner;
            this.concurringPartnerName = concurringPartnerName;
        }

        public String getMic() {
            return mic;
        }

        public void setMic(String mic) {
            this.mic = mic;
        }

        public String getMicName() {
            return micName;
        }

        public void setMicName(String micName) {
            this.micName = micName;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getPicName() {
            return picName;
        }

        public void setPicName(String picName) {
            this.picName = picName;
        }

        public String getPpic1() {
            return ppic1;
        }

        public void setPpic1(String ppic1) {
            this.ppic1 = ppic1;
        }

        public String getPpicName() {
            return ppicName;
        }

        public void setPpicName(String ppicName) {
            this.ppicName = ppicName;
        }

        public String getCpic() {
            return cpic;
        }

        public void setCpic(String cpic) {
            this.cpic = cpic;
        }

        public String getCpicName() {
            return cpicName;
        }

        public void setCpicName(String cpicName) {
            this.cpicName = cpicName;
        }

        public String getCompanyCode() {
            return companyCode;
        }

        public void setCompanyCode(String companyCode) {
            this.companyCode = companyCode;
        }

        public String getConfidentialRisk() {
            return confidentialRisk;
        }

        public void setConfidentialRisk(String confidentialRisk) {
            this.confidentialRisk = confidentialRisk;
        }

        public String getRegionCode() {
            return regionCode;
        }

        public void setRegionCode(String regionCode) {
            this.regionCode = regionCode;
        }

        public String getLocationCode() {
            return locationCode;
        }

        public void setLocationCode(String locationCode) {
            this.locationCode = locationCode;
        }

        public String getRcCode() {
            return rcCode;
        }

        public void setRcCode(String rcCode) {
            this.rcCode = rcCode;
        }

        public String getIsMasterEng() {
            return isMasterEng;
        }

        public void setIsMasterEng(String isMasterEng) {
            this.isMasterEng = isMasterEng;
        }
    }
}


