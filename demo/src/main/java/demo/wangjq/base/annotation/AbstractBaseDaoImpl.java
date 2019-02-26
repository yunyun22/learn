package demo.wangjq.base.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wangjq on 2019/2/26.
 */
public class AbstractBaseDaoImpl<T, K> {
    private Class<T> entityClass;
    private Class<T> primaryKeyClass;

    public AbstractBaseDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        Type[] typeParameters = pt.getActualTypeArguments();
        entityClass = (Class<T>) typeParameters[0];
        primaryKeyClass = (Class<T>) typeParameters[1];
    }

    public void save(T t) {
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(entityClass.getSimpleName());

        sb.append("(");
        Field[] fields = entityClass.getDeclaredFields();
        String fieldNames = Arrays.asList(fields).stream().map(x -> x.getName()).collect(Collectors.joining(","));
        sb.append(fieldNames);
        sb.append(") VALUES(");
        sb.append(fieldNames.replaceAll("[^,]+", "?"));
        sb.append(")");

        System.out.println(sb.toString());
        //根据反射还要遍历fields处理变量绑定，略。
    }

    public void delete(K k) {
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(entityClass.getSimpleName());
        sb.append(" WHERE ID=?");// 这里默认主键名为id，应该配合注解动态获取主键名
        System.out.println(sb.toString());
    }

    public void update(T t) {
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(entityClass.getSimpleName());
        sb.append(" SET ");
        Field[] fields = entityClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().toLowerCase().equals("id")) {
                continue;
            }
            sb.append(fields[i].getName());
            sb.append("=?");
            if (i < fields.length - 1) {
                sb.append(",");
            }
        }
        sb.append(" WHERE ID=?");
        System.out.println(sb.toString());
    }

    public T get() throws Exception {
        T t = null;
        // 模拟resultset
        Map<String, Object> rs = new HashMap<>();
        t = entityClass.newInstance();
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(t, rs.get(field.getName()));
        }
        return t;
    }

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user1 = new User();
        userDao.save(user1);
        userDao.delete(1);
        userDao.update(user1);
        try {
            User user2 = userDao.get();
            System.out.println(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
