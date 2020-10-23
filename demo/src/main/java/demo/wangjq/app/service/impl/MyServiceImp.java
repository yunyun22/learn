package demo.wangjq.app.service.impl;

import demo.wangjq.app.jdbc.MyJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyServiceImp {


    @Transactional(propagation = Propagation.NESTED)
    public void insertTeacher() throws Exception {
        System.out.println("OK");
    }
}
