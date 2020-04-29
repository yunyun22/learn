package demo.wangjq.base.designpattern;


/**
 * 需要被代理的接口
 */
public interface TargetService {
    /**
     * 用于jdk代理，必须要定义接口
     */
    void sayHello();
}