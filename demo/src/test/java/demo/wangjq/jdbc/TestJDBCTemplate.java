package demo.wangjq.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

import demo.wangjq.BaseTest;
import demo.wangjq.app.domain.UmsMember;

/**
 * Created by wangjq on 2019/2/26.
 */
public class TestJDBCTemplate extends BaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final String sql = "SELECT * FROM ums_member";

    @Test
    public void testQuery() {
        RowMapper<UmsMember> rm = BeanPropertyRowMapper.newInstance(UmsMember.class);
        List<UmsMember> list = jdbcTemplate.query(sql, rm);
        for (UmsMember umsMember : list) {
            System.out.println(umsMember);
        }
    }
}
