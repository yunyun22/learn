package demo.wangjq.feign;

import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.List;

/**
 * @author wang, jinqiao
 * @title: MyApp
 * @date 19/12/2019
 */
public class MyApp {

    public static void main(String... args) {
        GitHub github = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        // Fetch and print a list of the contributors to this library.
        List<GitHub.Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (GitHub.Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }
    }
}
