package demo.wangjq.app.beandefinition.circulate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@Lazy
public class Wife {

    public Wife() {
        System.out.println("===============this is init ");
    }


}
