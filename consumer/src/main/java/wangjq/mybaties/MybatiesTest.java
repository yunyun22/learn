package wangjq.mybaties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatiesTest {
    public static void main(String[] args) throws IOException {

        String resource = "mybaties-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        session.selectOne("selectStudents","105");
        //StudentMapper mapper = session.getMapper(StudentMapper.class);
        //mapper.selectStudents("108");
        try {
        } finally {
            session.close();
        }
    }
}
