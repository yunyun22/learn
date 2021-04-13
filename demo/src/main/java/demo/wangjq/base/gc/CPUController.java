package demo.wangjq.base.gc;


/**
 *
 */
public class CPUController {


    static int BUSY_TIME = 10;
    static int IDLE_TIME = BUSY_TIME;

    public static void main(String[] args) throws InterruptedException {

        long startTime;
        while (true) {
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < BUSY_TIME) ;
            Thread.sleep(IDLE_TIME);
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
