package com.parth.kafka.consumer;
import com.parth.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "Parth", groupId = "myGroup")
//    public void consumeMsg(String msg){
//        log.info(String.format("Consuming the message from Parth Topic:: %s",msg));
//
//    }
    @KafkaListener(topics = "Parth", groupId = "myGroup")
    public void consumeJsonMsg(Student student){
        log.info(String.format("Consuming the message from Parth Topic:: %s",student.toString()));
    }
}
