package demo.wangjq.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjq on 2019/2/15.
 */
public class Zookeeper {
    private final static String connectString = "47.105.64.68:2181";

    private final static int sessionTimeout = 5000;
    private static ZooKeeper zkClient = null;

    public static void main(String[] args) throws InterruptedException, IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, event -> {
            try {
                getConnection();
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            List<String> list = zkClient.getChildren("/", true);
            for (String s : list) {
                System.out.println(s);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        TimeUnit.DAYS.sleep(Long.MAX_VALUE);
    }

    public static void getConnection() throws KeeperException, InterruptedException {
        List<String> list = zkClient.getChildren("/", true);
        for (String s : list) {
            System.out.println(s);
        }
    }


}
