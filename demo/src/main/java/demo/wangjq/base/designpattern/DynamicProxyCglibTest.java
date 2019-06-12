package demo.wangjq.base.designpattern;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangjq
 */
public class DynamicProxyCglibTest {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyTarget.class);
        enhancer.setCallback(new MyEnhancer());
        MyTarget sample = (MyTarget) enhancer.create();
        sample.sayHello();
    }
}

class MyEnhancer implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before method run...");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("after method run...");
        return result;
    }
}

/**
 * 被代理的目标类
 */
class MyTarget {

    /**
     * 被增强的方法
     */
    public void sayHello() {
        System.out.println("say hello");
    }

}
