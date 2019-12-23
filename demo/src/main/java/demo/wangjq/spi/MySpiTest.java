package demo.wangjq.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author wangjq
 */
public class MySpiTest {

    public static void main(String[] args) {


        Iterator<MySpiService> providers = Service.providers(MySpiService.class);
        ServiceLoader<MySpiService> load = ServiceLoader.load(MySpiService.class);

        while (providers.hasNext()) {
            MySpiService ser = providers.next();
            ser.sayHello();
        }
        
        System.out.println("--------------------------------");

        Iterator<MySpiService> iterator = load.iterator();
        while (iterator.hasNext()) {
            MySpiService ser = iterator.next();
            ser.sayHello();
        }

    }
}
