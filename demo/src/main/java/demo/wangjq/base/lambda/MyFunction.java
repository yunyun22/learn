package demo.wangjq.base.lambda;

import java.io.Serializable;

/**
 * @author wang, jinqiao
 * @title: MyFunction
 * @date 06/01/2021
 */
public interface MyFunction<T> extends Serializable {

    T get();
}
