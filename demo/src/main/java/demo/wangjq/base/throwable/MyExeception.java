package demo.wangjq.base.throwable;

/**
 * Created by wangjq on 2018/8/31.
 */
public class MyExeception extends RuntimeException {


    public MyExeception(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, false);
    }

}
