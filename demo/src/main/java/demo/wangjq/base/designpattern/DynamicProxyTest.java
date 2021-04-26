package demo.wangjq.base.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangjq
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        TargetImpl target = new TargetImpl();
        MyInvokerHandlerProxy myInvokerHandlerProxy = new MyInvokerHandlerProxy(target);
        /*
         * 获取代理后的对象。
         */
        TargetService service = (TargetService) myInvokerHandlerProxy.getProxy();
        /*
         * 调用代理后的方法。
         */
        service.sayHello();

    }
}

/**
 * 对代理的类做增强作用
 */
class MyInvokerHandlerProxy implements InvocationHandler {

    private final TargetService target;

    /**
     * 构造方法
     *
     * @param target 目标对象
     */
    public MyInvokerHandlerProxy(TargetService target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标对象的方法执行之前简单的打印一下
        System.out.println("------------------before------------------");
        // 执行目标对象的方法
        //method 获取的是接口上的方法
        //System.out.println(proxy);
        Object result = method.invoke(target, args);
        System.out.println(proxy);
        // 在目标对象的方法执行之后简单的打印一下
        System.out.println("-------------------after------------------");
        return result;
    }

    /**
     * 获取目标对象的代理对象。参数this代表着将增强类传入了Proxy
     *
     * @return 代理对象
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}

/**
 * 实现类
 */
class TargetImpl implements TargetService {
    @Override
    public synchronized void sayHello() {
        System.out.println("hello world");
    }
}
