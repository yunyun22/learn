package demo.wangjq.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.wangjq.app.annotaation.MyAnnotation;

/**
 * @author wangjq
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login.html")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/test/{name}")
    @ResponseBody
    public String testPathVariable(@PathVariable("name") String name) {
        return "hello " + name;
    }

    @GetMapping("/resolver")
    @ResponseBody
    public String testResolver(@MyAnnotation String message) {
        return "hello " + message;
    }

}
