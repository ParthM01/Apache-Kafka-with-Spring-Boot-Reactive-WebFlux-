package com.parth.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {


    @KafkaListener(topics = "wikimedia-stream")
    public void consumeWikimediaMsg(String msg){
            log.info(String.format("Consuming the message from Wikimedia Topic:: %s",msg));
        }


}
