package cici.kafka;

import cici.kafka.config.KafkaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

/**
 * @author pengjiaqi
 * @date 2021/2/23
 * @description TODO
 */
public class KafkaProducer {
    private final static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    //使用spring-kafka的template发送一条消息 发送多条消息只需要循环多次即可
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        logger.info("测试打印日志");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KafkaConfig.class);
        KafkaTemplate<Integer, String> kafkaTemplate = (KafkaTemplate<Integer, String>) ctx.getBean("kafkaTemplate");
        String data="this is a test cici";
        ListenableFuture<SendResult<Integer, String>> send = kafkaTemplate.send("topic-test", 1, data);
        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            public void onFailure(Throwable throwable) {

            }

            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {

            }
        });
    }
}
