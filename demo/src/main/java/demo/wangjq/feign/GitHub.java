package demo.wangjq.feign;

import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * @author wang, jinqiao
 * @title: Github
 * @date 19/12/2019
 */
public interface GitHub {
    public static class Contributor {
        String login;
        int contributions;
    }


    /**
     * 获取github仓库的共享人
     * @param owner 拥有者
     * @param repo 仓库
     * @return
     */
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);


}

