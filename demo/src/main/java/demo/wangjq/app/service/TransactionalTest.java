package demo.wangjq.app.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wang, jinqiao
 * @title: TransactionalTest
 * @date 06/12/2019
 */
@Service
public class TransactionalTest {

    @Resource(name = "jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;

    @Resource(name = "jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    public static final String INSERT_PERSON = "INSERT INTO person(age) VALUES(1)";

    public static final String INSERT_CLOTHING = "INSERT INTO clothing VALUE(20)";


    @Transactional(rollbackFor = RuntimeException.class)
    public void update() {
        jdbcTemplate1.execute(INSERT_PERSON);
        int i = 1 / 0;
        jdbcTemplate2.execute(INSERT_CLOTHING);

    }

    public static final String SQL = "DELETE FROM person WHERE name=? ";

//    @Transactional(rollbackFor = RuntimeException.class)
//    public void delete(String name) {
//        jdbcTemplate.update(SQL, name);
//        throw new RuntimeException();
//    }
}
