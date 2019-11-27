package demo.wangjq.base;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.wangjq.app.beandefinition.Student;

/**
 * @author:wangjq
 * @Date: 2019/7/24 15:13
 */
public class BeanUtil {

    /**
     * 将对象转成map
     *
     * @param o 对象
     * @return map
     */
    public static Map<String, ?> objectToMap(Object o) throws InvocationTargetException, IllegalAccessException, IntrospectionException {
        Class clazz = o.getClass();

        List<Class> classes = new ArrayList<>();
        classes.add(clazz);

        Class supperClass = clazz.getSuperclass();

        while (supperClass != null) {
            classes.add(supperClass);
            supperClass = supperClass.getSuperclass();
        }


        List<Field> list = new ArrayList<>();

        for (Class declaredClass : classes) {
            if (!declaredClass.isInterface()) {
                list.addAll(Arrays.asList(declaredClass.getDeclaredFields()));
            }
        }

        Map<String, Object> map = new HashMap(list.size());
        for (Field field : list) {

            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
            map.put(field.getName(), propertyDescriptor.getReadMethod().invoke(o, new Object[]{}));
        }

        return map;
    }


    private List<PropertyDescriptor> getPropertyDescriptor(String[] fieldNames, Class clazz) throws IntrospectionException {


        List<PropertyDescriptor> list = new ArrayList<>(fieldNames.length);

        for (String fieldName : fieldNames) {

            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, clazz);
            list.add(propertyDescriptor);
        }


        return list;

    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IntrospectionException {

        Student student = new Student();
        student.setName("wa");
        student.setSex("man");
        student.setColor("black");
        Map<String, ?> map = BeanUtil.objectToMap(student);

        System.out.println(map);

    }


}
