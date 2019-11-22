package demo.wangjq.app.beandefinition.circulate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Lazy
@Component
public class Husband {


    @Autowired
    public Wife wife;


    public Wife getWife() {
        return wife;
    }
}
