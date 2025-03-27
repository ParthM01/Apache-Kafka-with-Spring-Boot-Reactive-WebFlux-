package com.parth.kafka.producer;

import com.parth.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String,Student> KafkaTemplate ;

    public void sendMessage(Student student){

        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC,"Parth")
                .build();

        KafkaTemplate.send(message);
    }
}
