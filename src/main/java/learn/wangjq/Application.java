package learn.wangjq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    @Autowired
    private StringToDateConverter stringToDateConverter;

    @RequestMapping
    @ResponseBody
    public String home(DateDto dateDto) {
        System.out.println(dateDto);
        return "Hello World!";
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

    }
//    @InitBinder
//    public void init(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//
//    }
}
