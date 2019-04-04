package demo.wangjq.app.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:wangjq
 * @Date: 2019/4/4 11:36
 */
@RestController()
@RequestMapping("/test")
public class TestController {

    @RequestMapping(headers = {"method=test"}, method = RequestMethod.GET)
    public String testHeader(@RequestHeader("myHeader") String name) {
        return name;
    }
}
