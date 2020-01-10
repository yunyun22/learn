package server.wangjq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangjq
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("test");
        new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
        logger.error("this is error");
        logger.error("this is error");
        logger.error("this is error");
        logger.error("this is error");
        logger.error("this is error");
        logger.error("this is error");
        logger.error("this is error");
        logger.error("this is error");
        logger.error("this is error");
        logger.error("this is error");
    }

}