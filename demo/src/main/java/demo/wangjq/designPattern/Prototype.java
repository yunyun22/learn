package demo.wangjq.designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjq on 2018/7/9.
 */
public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        XiaoMiPhone xiaoMiPhone = new XiaoMiPhone();
        xiaoMiPhone.setVersion("1.0");
        List<String> programs = new ArrayList<>();
        programs.add("desktop");
        xiaoMiPhone.setProgram(programs);




        System.out.println("==============Prototype is :" + xiaoMiPhone);
        XiaoMiPhone xiaoMiPhoneClone = (XiaoMiPhone) xiaoMiPhone.clone();
        System.out.println("==============clone is :" + xiaoMiPhoneClone);

        System.out.println("programs is sample object:" + (xiaoMiPhone.getVersion() == xiaoMiPhoneClone.getVersion()));

    }
}



