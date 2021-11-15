package demo.wangjq.base.vm;

/**
 * @author wang, jinqiao
 * @title: HeapSizeTest
 * @date 23/07/2021
 */
public class HeapSizeTest {
    /*
    -Xms10m -Xmx10m -XX:NewRatio=3 -XX:NewSize=2m
    -XX:MaxNewSize=2300k
    -XX:+UseConcMarkSweepGC
    -XX:+PrintGC
    -XX:+PrintGCDetails
    -XX:+PrintGCTimeStamps
    -XX:+PrintGCDateStamps
    -XX:+PrintHeapAtGC
    -Xloggc:../logs/gc.log
     */
    /**
     * -Xms10m -Xmx10m -XX:NewRatio=3 -XX:NewSize=2m
     * -XX:MaxNewSize=2300k
     * -XX:+UseConcMarkSweepGC
     * -XX:+PrintGC
     * -XX:+PrintGCDetails
     * -XX:+PrintGCTimeStamps
     * -XX:+PrintGCDateStamps
     * -XX:+PrintHeapAtGC
     * -Xloggc:../logs/gc.log
     * @param args
     */
    public static void main(String[] args) {

        for (int i =0;i<10000;i++){
            byte[]  b = new byte[1024];
        }
    }
}
