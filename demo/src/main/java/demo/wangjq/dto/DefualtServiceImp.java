package demo.wangjq.dto;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service("defualtServiceImp")
public class DefualtServiceImp implements Service {
    @Override
    public String toString() {
        return "DefualtServiceImp{}";
    }
}
