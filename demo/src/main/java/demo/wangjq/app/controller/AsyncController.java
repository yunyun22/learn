package demo.wangjq.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * @author:wangjq
 * @Date: 2019/8/21 14:18
 */
@Controller
@RequestMapping("async")
public class AsyncController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public WebAsyncTask<String> hello() {

        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "hello task";
        };

        return new WebAsyncTask<>(10000, callable);
    }

}
