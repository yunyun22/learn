package learn.wangjq.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;


@Repository
public class MyJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertStudent() {
        Random r = new Random();
        int no = r.nextInt(1000);
        String noStr = String.valueOf(no);
        String sql = "INSERT  INTO STUDENTS VALUES (" + noStr + ",'www','女', NOW() ,'11111')";
        System.out.println(sql);
        return jdbcTemplate.update(sql);
    }

}
