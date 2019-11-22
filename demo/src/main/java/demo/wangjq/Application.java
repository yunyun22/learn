package demo.wangjq;

import demo.wangjq.app.beandefinition.SpringContextHolder;
import demo.wangjq.app.beandefinition.circulate.Husband;
import demo.wangjq.app.beandefinition.circulate.Wife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

import demo.wangjq.app.servlet.MyServlet;

/**
 * @author wangjq
 */
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@Controller
@EnableAsync
@EnableCaching
public class Application {


    @Bean
    public ServletRegistrationBean MyServlet1() {
        return new ServletRegistrationBean(new MyServlet(), "/myserv/*");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        Husband husband = SpringContextHolder.getBean("husband");
        Wife wife = husband.wife;
        System.out.println(wife);
        wife = husband.getWife();
        System.out.println(wife);
        //Application
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
