package demo.wangjq.app.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author:wangjq
 * @Date: 2019/9/2 15:21
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class ExamplePlugin implements Interceptor {

    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // implement pre processing if need
        System.out.println("implement pre processing if need");
        Object[] args = invocation.getArgs();


        System.out.println(invocation.getArgs()[0]);
        System.out.println(invocation.getArgs()[1]);
        System.out.println(invocation.getArgs()[2]);
        System.out.println(invocation.getArgs()[3]);

        Object returnObject = invocation.proceed();
        System.out.println("implement post processing if need");
        // implement post processing if need
        return returnObject;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
