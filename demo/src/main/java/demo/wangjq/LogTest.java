package demo.wangjq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTest {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.trace("=====trace=====");
        logger.debug("=====debug=====");
        logger.info("=====info=====");
        logger.warn("=====warn=====");
        logger.error("=====error=====");
    }
}
