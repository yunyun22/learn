package learn.wangjq.service.impl;

import learn.wangjq.jdbc.MyJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyServiceImp {

    @Autowired
    private MyJdbc myJdbc;

    @Transactional(propagation = Propagation.NESTED)
    public void insertTeacher() throws Exception{
        myJdbc.insertStudent();
        throw  new RuntimeException();
    }
}
