package demo.wangjq.app.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import demo.wangjq.app.service.CacheService;
import demo.wangjq.base.annotation.User;

/**
 * @author:wangjq
 * @Date: 2019/5/5 15:59
 */
@Service
public class CacheServiceImpl implements CacheService {
    @Override
    @Cacheable(value = "user")
    public User cache(String name) {
        /**
         * 模拟数据库查询速度慢
         */
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User().builder().setId(1).setName(name);
    }

    @Override
    @Cacheable(value = "list")
    public List<Integer> cacheList() {
        return Arrays.asList(1, 2, 4, 5);
    }
}
