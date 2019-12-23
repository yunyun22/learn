package demo.wangjq.app.controller;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import com.netflix.niws.client.http.RestClient;
import demo.wangjq.app.annotaation.MyAnnotation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.util.List;

/**
 * @author wangjq
 */
@Controller
public class IndexController {


    @Autowired
    private SpringClientFactory clientFactory;


    @RequestMapping("/test/server/list")
    public void getServerList() {
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        ZoneAwareLoadBalancer<Server> lb = (ZoneAwareLoadBalancer<Server>) clientFactory.getLoadBalancer("test");
        ServerList<Server> serverList = lb.getServerListImpl();
        List<Server> serverDetailList = serverList.getInitialListOfServers();
        if (!CollectionUtils.isEmpty(serverDetailList)) {
            for (Server s : serverDetailList) {
                System.out.println(s.getHost() + "," + s.getPort());
            }
        } else {
            System.out.println("no service");
        }
        return "fuck";
    }

    @RequestMapping("/remote")
    @ResponseBody
    public String remote() throws Exception {
        RestClient client = (RestClient) ClientFactory.getNamedClient("test");
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("/")).build();
        for (int i = 0; i < 20; i++) {
            HttpResponse response = client.executeWithLoadBalancer(request);
            System.out.println("Status code for " + response.getRequestedURI() + "  :" + response.getStatus());
        }
        return "OK";

    }

    @RequestMapping("/login.html")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/test/{name}")
    @ResponseBody
    public String testPathVariable(@PathVariable("name") String name) {
        return "hello " + name;
    }

    @GetMapping("/resolver")
    @ResponseBody
    public String testResolver(@MyAnnotation String message) {
        return "hello " + message;
    }

}
