package demo.wangjq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wang, jinqiao
 * @title: TransactionalTest
 * @date 06/12/2019
 */
public class TransactionalTest extends BaseTest {

    @Autowired
    private demo.wangjq.app.service.TransactionalTest transactionalTest;

    @Test
    public void testTransactional() {
        transactionalTest.update();
    }
}
