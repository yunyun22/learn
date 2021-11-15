package demo.wangjq.kafka.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author wang, jinqiao
 * @date 13/05/2021
 */
public class NewCustomPartitioner implements Partitioner {

    int i = 1;

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        i++;
        System.out.println("the message partition:" + i % 2);
        return 1;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }

    @Override
    public void onNewBatch(String topic, Cluster cluster, int prevPartition) {

    }
}
