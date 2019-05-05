package demo.wangjq.app.service;

import java.util.List;

import demo.wangjq.base.annotation.User;

/**
 * @author:wangjq
 * @Date: 2019/5/5 15:58
 */
public interface CacheService {

    /**
     * 缓存当前操作者的名字
     *
     * @param name 名称
     * @return 返回名称
     */
    User cache(String name);

    /**
     * 缓存list
     *
     * @return list
     */
    List<Integer> cacheList();

}
