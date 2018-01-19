package learn.wangjq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class Application {

    //@Autowired
    //private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @RequestMapping("/home")
    @ResponseBody
    public String home(@RequestBody DateDto dateDto) {
        System.out.println(dateDto);
        return "Hello World!";
    }

    @RequestMapping("/world")
    @ResponseBody
    public String world(String json) {
        return "Hello World!";
    }

    @RequestMapping("/root")
    public ModelAndView index() {
        System.out.println("start in index");
        return new ModelAndView("index.html");
    }


    public static void main(String[] args) throws Exception {
        //SpringApplication.run(Application.class, args);

        Long[] l = new Long[10];

        new Thread(()->{
           // l=new Long[20];
        });
    }

    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置日期格式
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(smt);
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }
}
