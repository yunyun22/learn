package demo.wangjq.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wang, jinqiao
 * @title: TransactionalTest
 * @date 06/12/2019
 */
@Service
public class TransactionalTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void update() {
        try {
            jdbcTemplate.update(SQL, "tt");
            delete("wangjq");
        } catch (RuntimeException r) {
            r.printStackTrace();
        }
        /**
         * new add runtimeException
         */
        throw new RuntimeException();

    }

    public static final String SQL = "DELETE FROM person WHERE name=? ";

    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(String name) {
        jdbcTemplate.update(SQL, name);
        throw new RuntimeException();
    }
}
