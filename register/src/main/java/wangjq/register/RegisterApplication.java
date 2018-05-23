package wangjq.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
@Controller
public class RegisterApplication {

    @Value("${name}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; //just here for testing

    @RequestMapping("/hello")
    @ResponseBody
    public String getHelloFromRrgister() {
        return restTemplate.getForObject("http://register/helloWorld", String.class);
    }

    private Boolean isInstanceAvailable() {
        List<ServiceInstance> instances = discoveryClient.getInstances("register");
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

    @RequestMapping("/helloWorld")
    @ResponseBody
    public String getHelloFromDemo() {
        isInstanceAvailable();
        return "hello world,"+name;
        //return restTemplate.getForObject("http://DEMO/helloWorld",String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }
}
