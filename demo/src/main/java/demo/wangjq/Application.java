package demo.wangjq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import demo.wangjq.config.Student;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Controller
public class Application {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Student student;

    @Autowired
    private DiscoveryClient discoveryClient; //just here for testing

    @RequestMapping("/getJson")
    @ResponseBody
    public ModelAndView getJson() {
        return new ModelAndView("a.json");
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String getHelloFromRrgister() {

        isInstanceAvailable();
        return restTemplate.getForObject("http://demo/helloWorld", String.class);
    }

    @RequestMapping("/helloWorld")
    @ResponseBody
    public String helloWorld() {
        return "hello world " + student.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

    }

    private Boolean isInstanceAvailable() {
        List<ServiceInstance> instances = discoveryClient.getInstances("demo");
        System.out.println("get instance:" + instances);
        for (ServiceInstance si : instances) {
            System.out.print("service:");
            System.out.print(si.getUri().toString());
        }
        return instances.size() > 0;
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Autowired
//    private List<Service> list;
//
//    @Autowired
//    private JdbcService jdbcService;
//
//
//
//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping("/logout")
//    public String logout() {
//        return "logout";
//    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping("/home")
//    @ResponseBody
//    public String home() {
//        return "Hello World";
//    }
//
//    @RequestMapping("/world")
//    @ResponseBody
//    public String world(String json) {
//        return "Hello World!";
//    }
//
//
//    @Bean
//    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        //设置日期格式
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
//        objectMapper.setDateFormat(smt);
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//        //设置中文编码格式
//        List<MediaType> list = new ArrayList<MediaType>();
//        list.add(MediaType.APPLICATION_JSON_UTF8);
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
//        return mappingJackson2HttpMessageConverter;
//    }
//
//    @Override
//    public String toString() {
//        return "Application";
//    }
}
