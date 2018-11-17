package demo.wangjq.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wangjq on 2018/6/12.
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

        MyInvokerHandler myInvokerHandler = new MyInvokerHandler();

        MyInvokerHandlerProxy myInvokerHandlerProxy = new MyInvokerHandlerProxy(myInvokerHandler);


        /**
         * 获取代理后的对象。
         */
        InvokerHandler invokerHandler = (InvokerHandler) myInvokerHandlerProxy.getProxy();

        /**
         * 调用代理后的方法。
         */
        /**
         * <code>
         *
         *   //动态代理生成字节码反编译后的代码
         *   public final class $Proxy11 extends Proxy implements InvokerHandler{
         *
         *      public final void myHandler() throws  {
         *          try {
         *              // protected InvocationHandler h;
         *              super.h.invoke(this, m3, (Object[])null);
         *          } catch (RuntimeException | Error var2) {
         *              throw var2;
         *          }
         *      }
         *
         *  }
         *
         *
         *
         *   class MyInvokerHandlerProxy implements InvocationHandler {
         *
         *      //获取的代理是$Proxy11的实例，也是Proxy的实例
         *      public Object getProxy() {
         *          return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
         *                  target.getClass().getInterfaces(), this);
         *      }
         *   }
         *
         *  jdk 动态代理的流程。实例化出目标类。实例化增强类。生成代理里getProxy()，将增强传入到代理类中。
         *  代理类调用增强的方法
         *
         *
         * </code>
         */

        invokerHandler.myHandler();


    }
}

/**
 * 对代理的类做增强作用
 */
class MyInvokerHandlerProxy implements InvocationHandler {


    private Object target;


    /**
     * 构造方法
     *
     * @param target 目标对象
     */
    public MyInvokerHandlerProxy(Object target) {
        super();
        this.target = target;


    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标对象的方法执行之前简单的打印一下
        System.out.println("------------------before------------------");

        // 执行目标对象的方法
        Object result = method.invoke(target, args);

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
 * invokerHandler 实现类
 */
class MyInvokerHandler implements InvokerHandler {
    @Override
    public void myHandler() {
        System.out.println("I am a handler");
    }
}

interface InvokerHandler {
    void myHandler();
}