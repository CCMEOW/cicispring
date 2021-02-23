package cici.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;


/**
 * @author pengjiaqi
 * @date 2021/2/23
 * @description TODO
 */
public class KafkaConsumer {
    private final static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    private final CountDownLatch latch1 = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "topic-test")
    public void listen(byte[] records) {
        //do something here
        this.latch1.countDown();
    }
}
