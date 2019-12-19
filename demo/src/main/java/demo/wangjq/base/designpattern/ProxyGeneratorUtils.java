package demo.wangjq.base.designpattern;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wangjq
 */
public class ProxyGeneratorUtils {


    public static void main(String[] args) {
        ProxyGeneratorUtils.writeProxyClassToHardDisk("C:/Users/jinqwang/$Proxy11.class");
    }

    /**
     * 把代理类的字节码写到硬盘上
     *
     * @param path 保存路径
     */
    public static void writeProxyClassToHardDisk(String path) {
        // 第一种方法，这种方式在刚才分析ProxyGenerator时已经知道了
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);


        // 获取代理类的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", MyInvokerHandler.class.getInterfaces());

        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

