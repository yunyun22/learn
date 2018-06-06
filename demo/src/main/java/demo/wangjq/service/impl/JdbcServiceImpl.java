package demo.wangjq.service.impl;

import demo.wangjq.jdbc.MyJdbc;
import demo.wangjq.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

public class JdbcServiceImpl implements JdbcService {

    @Autowired
    private MyJdbc myJdbc;

    @Autowired
    private MyServiceImp myServiceImp;

    /**
     * 测试，nested 的传播性
     */
    @Override
    //@Transactional(propagation = Propagation.REQUIRED)
    public void insertStudent() {
        int count = myJdbc.insertStudent();
        //myServiceImp.insertTeacher();
        System.out.println("success count:" + count);
        try {
            insertTeacher();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
   // @Transactional(propagation = Propagation.NESTED)
    public void insertTeacher() throws Exception {
        int count = myJdbc.insertStudent();
        throw new RuntimeException("test exception");
        //myServiceImp.insertTeacher();
    }


}
