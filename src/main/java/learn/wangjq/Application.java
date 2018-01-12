package learn.wangjq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

@Controller
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/home")
    @ResponseBody
    public String home(@RequestBody DateDto dateDto) {
        return "Hello World!";
    }

    @RequestMapping("/root")
    public ModelAndView index() {
        System.out.println("start in index");
        return new ModelAndView("index.html");
    }


    public static void main(String[] args) throws Exception {
       SpringApplication.run(Application.class, args);
//        Properties pro = new Properties();
//        URL url = Application.class.getResource("/application.properties");
//        URL url2 = Application.class.getResource("/");
//        URL urlClassLoader = Application.class.getClassLoader().getResource("");
//        URL urlClassLoader2 = Application.class.getClassLoader().getResource("");
//        System.out.println("url2:"+url2);
//        System.out.println("urlClassLoader:"+urlClassLoader);
//        System.out.println("urlClassLoader2:"+urlClassLoader2);
//        System.out.println(url);
//        FileInputStream in = new FileInputStream(url.getFile());
//        pro.load(in);
//        System.out.println(pro.get("x"));
//        in.close();
//        FileOutputStream out = new FileOutputStream(url.getFile());
//        pro.setProperty("x", "234");
//        pro.store(out,"x");
//        out.close();
    }
}
