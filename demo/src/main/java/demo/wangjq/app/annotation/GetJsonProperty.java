package demo.wangjq.app.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:wangjq
 * @Date: 2019/8/12 15:28
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GetJsonProperty {
    String value() default "";

    /**
     * 获取json的名字
     */
    String name() default "";
}
