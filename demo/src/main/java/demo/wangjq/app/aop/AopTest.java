package demo.wangjq.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Component;

/**
 * @author:wangjq
 * @Date: 2019/4/18 11:57
 */
@Aspect
@Component
public class AopTest {
    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;
    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Pointcut("execution(public * demo.wangjq.app.controller.*.*(..))")
    public void pointCut() {

    }


    @Around("pointCut()")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int numAttempts = 0;
        PessimisticLockingFailureException lockFailureException;
        do {
            numAttempts++;
            try {
                System.out.println("come in aop");
                return pjp.proceed();
            } catch (PessimisticLockingFailureException ex) {
                lockFailureException = ex;
            }
        } while (numAttempts <= this.maxRetries);
        throw lockFailureException;
    }
}
