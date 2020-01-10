package demo.wangjq.app.controller;

import demo.wangjq.app.annotaation.GetJsonProperty;
import demo.wangjq.app.service.CacheService;
import demo.wangjq.app.service.TransactionalTest;
import demo.wangjq.base.annotation.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:wangjq
 * @Date: 2019/4/4 11:36
 */
@RestController()
@RequestMapping("/test")
public class TestController {


    @Autowired
    private CacheService cacheService;

    @Autowired
    private TransactionalTest transactionalTest;

    @RequestMapping("/insert")
    @ResponseBody
    public String insert() {
        transactionalTest.update();
        return "OK";
    }

    @RequestMapping(headers = {"method=test"}, method = RequestMethod.GET)
    public String testHeader(@RequestHeader("myHeader") String name) {
        return name;
    }


    @RequestMapping("/cache")
    @ResponseBody
    public User testCache(Long acId) {
        return cacheService.cache(acId);
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Integer> testCache() {
        return cacheService.cacheList();
    }

    @RequestMapping(value = "/getJson", method = RequestMethod.POST)
    @ResponseBody
    public String getJson(@GetJsonProperty("fuck") Map<String, Object> map, @GetJsonProperty int age) {
        return "fuck:" + map;
    }
}
