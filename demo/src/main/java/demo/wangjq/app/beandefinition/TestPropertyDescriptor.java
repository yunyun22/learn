package demo.wangjq.app.beandefinition;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class TestPropertyDescriptor {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("wangjq");
        /**
         * 结果输出 zhangsan
         */
        getFiled(student, "name");
        System.out.println(student);
    }

    private static void getFiled(Object object, String field) {
        Class<? extends Object> clazz = object.getClass();
        PropertyDescriptor pd = null;
        Method getMethod = null;
        Method wirteMethod = null;
        try {
            pd = new PropertyDescriptor(field, clazz);
            if (null != pd) {

                getMethod = pd.getReadMethod();
                wirteMethod = pd.getWriteMethod();
                Object invoke = getMethod.invoke(object);
                System.out.println(invoke);
                Object invokeStr = wirteMethod.invoke(object,"wangjq2222222");
                System.out.println(invokeStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
