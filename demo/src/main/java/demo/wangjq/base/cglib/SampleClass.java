package demo.wangjq.base.cglib;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author wang, jinqiao
 * @date 18/12/2019
 */
public class SampleClass {
    int i = 0;
    public synchronized Integer test() {
        System.out.println(i++);
        return i;
    }
    public static void main(String[] args) {
        SampleClass sampleClass = new SampleClass();
        sampleClass.test();
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\TEMP");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invoke(sampleClass, args1));
        SampleClass sample = (SampleClass) enhancer.create();
        sample.test();
    }
}
