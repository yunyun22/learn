package demo.wangjq.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import demo.wangjq.BaseTest;

/**
 * Created by wangjq on 2019/2/26.
 */
public class TestJDBCTemplate extends BaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final String sql = "select * from ums_member";

    @Test
    public void testQuery() {
        jdbcTemplate.queryForList(sql);
    }
}
