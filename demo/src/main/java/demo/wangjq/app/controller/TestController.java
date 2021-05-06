package demo.wangjq.app.controller;

import demo.wangjq.app.service.impl.MyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import demo.wangjq.app.service.CacheService;
import demo.wangjq.base.annotation.User;

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
    private MyServiceImp myServiceImp;

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
    public String getJson() {
        return "fuck:" ;
    }
}
