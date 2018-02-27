package learn.wangjq.service.impl;

import learn.wangjq.jdbc.MyJdbc;
import learn.wangjq.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JdbcServiceImpl implements JdbcService {

    @Autowired
    private MyJdbc myJdbc;

    @Autowired
    private MyServiceImp myServiceImp;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertStudent() {
        int count = myJdbc.insertStudent();
        myServiceImp.insertTeacher();
        System.out.println("success count:" + count);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void insertTeacher() {
        //throw new RuntimeException();
    }


}
