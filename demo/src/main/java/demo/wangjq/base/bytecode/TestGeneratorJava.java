package demo.wangjq.base.bytecode;


import demo.wangjq.base.designpattern.TargetService;

import java.io.IOException;

/**
 * @author:wangjq
 * @Date: 2019/6/12 17:24
 */
public class TestGeneratorJava {
    public static void main(String[] args) throws IOException {
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(".demo.wangjq.base.designpattern.Service$Proxy0", new Class[]{TargetService.class});
    }
}
