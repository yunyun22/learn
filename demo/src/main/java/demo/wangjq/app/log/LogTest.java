package demo.wangjq.app.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangjq on 2018/6/14.
 */
public class LogTest {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.info("Hello World");
    }
}
