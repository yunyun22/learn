package learn.wangjq.dto;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service("SampleServiceImp")
public class SampleServiceImp implements Service {
    @Override
    public String toString() {
        return "SampleServiceImp{}";
    }
}
