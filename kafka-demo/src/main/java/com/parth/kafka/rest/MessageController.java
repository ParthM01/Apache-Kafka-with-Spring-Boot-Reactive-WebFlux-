package com.parth.kafka.rest;

import com.parth.kafka.payload.Student;
import com.parth.kafka.producer.KafkaJsonProducer;
import com.parth.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;


//    public MessageController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

    @PostMapping
    public ResponseEntity<String>  sendMessage (
            @RequestBody String message
    ){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message Queued Succesfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String>  sendJsonMessage (
            @RequestBody Student message
    ){
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message Queued Succesfully as Json");
    }



}
