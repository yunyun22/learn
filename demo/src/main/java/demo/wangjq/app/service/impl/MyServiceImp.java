package demo.wangjq.app.service.impl;

import demo.wangjq.app.jdbc.MyJdbc;
import org.springframework.beans.factory.annotation.Autowired;

public class MyServiceImp {

    @Autowired
    private MyJdbc myJdbc;

    //@Transactional(propagation = Propagation.NESTED)
    public void insertTeacher() throws Exception {
        myJdbc.insertStudent();
        throw new RuntimeException();
    }
}
