package demo.wangjq;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by wangjq on 2018/11/1.
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        URL url = PropertiesTest.class.getClassLoader().getResource("test.properties");
        try {
            properties.load(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
