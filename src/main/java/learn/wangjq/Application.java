package learn.wangjq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/home")
    @ResponseBody
    public String home(DateDto dateDto) {
        return "Hello World!";
    }

    @RequestMapping("/root")
    public ModelAndView index() {
        System.out.println("start in index");
        return new ModelAndView("index.html");
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
