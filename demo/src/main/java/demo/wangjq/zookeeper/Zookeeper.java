package demo.wangjq.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjq
 */
public class Zookeeper {
    private final static String CONNECT = "localhost:2181";

    private final static int SESSION_TIMEOUT = 5000;


    public static void printEvent(WatchedEvent event, ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        System.out.println("==========DefaultWatcher start==============");

        System.out.println("DefaultWatcher state: " + event.getState().name());

        System.out.println("DefaultWatcher type: " + event.getType().name());

        System.out.println("DefaultWatcher path: " + event.getPath());

        System.out.println("==========DefaultWatcher end==============");

        if (zooKeeper != null) {
            zooKeeper.getChildren(event.getPath(), event1 -> {
                try {
                    printEvent(event1, zooKeeper);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zkClient = new ZooKeeper(CONNECT, SESSION_TIMEOUT, event -> {
            try {
                printEvent(event, null);
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            List<String> list = zkClient.getChildren("/", event -> {
                try {
                    printEvent(event, zkClient);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(list);
//            ZooKeeper.States state = zkClient.getState();
//            System.out.println(state);

//            Stat exists = zkClient.exists("/test", false);
//            if (exists != null) {
//                System.out.println("The node already exist ,it will be deleted , info:" + exists.toString());
//
//            } else {
//                System.out.println("The node does not exist");
//            }
            // String realPath = zkClient.create("/test", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            // System.out.println("real path:" + realPath);


        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        TimeUnit.DAYS.sleep(Long.MAX_VALUE);
    }


}
