package demo.wangjq.kafka;

import demo.wangjq.kafka.interceptor.CounterInterceptor;
import demo.wangjq.kafka.interceptor.TimeStampPreSenderInterceptor;
import demo.wangjq.kafka.partitioner.NewCustomPartitioner;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjq
 */
public class KafkaProducerTest {


    public static final int SEND_NUMBER = 100;

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Properties kafkaProps = new Properties();
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        List<String> interceptors = new ArrayList<>();
        interceptors.add(TimeStampPreSenderInterceptor.class.getName());
        interceptors.add(CounterInterceptor.class.getName());

        kafkaProps.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
        kafkaProps.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, NewCustomPartitioner.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);

        //Topic Key Value
        for (int i = 0; i < SEND_NUMBER; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("test", "Precision Products", "France");
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    System.out.println("处理record");
                }else {
                   // System.out.println("发生成功");
                }
            }).get();
        }
        producer.close();

        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);


    }
}
