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
     * @param acId 名称
     * @return 返回名称
     */
    User cache(Long acId);

    /**
     * 缓存list
     *
     * @return list
     */
    List<Integer> cacheList();

}
