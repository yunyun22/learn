package demo.wangjq.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangjq
 */
@RestController()
@RequestMapping("/redis")
public class RedisController {

    private static Logger log = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/{key}")
    public String getValue(@PathVariable String key) {
        log.info("the method is getValue,it parameter is :" + key);
        return stringRedisTemplate.opsForValue().get(key);
    }

    @PostMapping()
    public String setValue(@RequestBody Map<String, String> map) {
        log.info("the method is setValue,it parameter is :" + map);
        stringRedisTemplate.opsForValue().multiSet(map);
        return "success";
    }


}
