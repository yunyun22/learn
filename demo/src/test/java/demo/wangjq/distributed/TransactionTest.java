package demo.wangjq.distributed;

import demo.wangjq.BaseTest;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wang, jinqiao
 * @title: TransactionTest
 * @date 10/01/2020
 */
public class TransactionTest extends BaseTest {

    @Resource(name = "jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;

    @Resource(name = "jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    public static final String INSERT_PERSON = "INSERT INTO person(age) VALUES(1)";

    public static final String INSERT_CLOTHING = "INSERT INTO clothing VALUE(20)";

    @Transactional
    @Test
    // @Rollback(false)
    public void insert() {
        jdbcTemplate1.execute(INSERT_PERSON);
        int i = 1 / 0;
        jdbcTemplate2.execute(INSERT_CLOTHING);
    }

}
