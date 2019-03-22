package demo.wangjq.base.gc;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjq on 2018/10/23.
 */
public class CPUController {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new User("w" + i++, i));
        }
    }

    static final class User {

        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
