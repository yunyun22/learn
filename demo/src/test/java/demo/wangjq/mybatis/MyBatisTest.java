package demo.wangjq.mybatis;


import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import demo.wangjq.app.domain.Employee;
import demo.wangjq.app.mapper.EmployeeMapper;

public class MyBatisTest {


    @Test
    public void hello() throws IOException, ClassNotFoundException {
        Class.forName("org.junit.Test");
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.selectEmployee(1, "wwww");
        System.out.println(employee);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setAge(20);
        employee1.setName("zzz");
        employeeMapper1.updateEmployee(employee1);
        sqlSession1.commit();

        employee = employeeMapper.selectEmployee(1, null);
        System.out.println(employee);
    }

    @Test
    public void shouldSuccessfullyLoadXMLMapperFile() throws Exception {
        Configuration configuration = new Configuration();
        String resource = "mybatis/EmployeeMapper.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        XMLMapperBuilder builder = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
        builder.parse();
        inputStream.close();
    }
}
