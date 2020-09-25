package com.sandhusanthakumar.demo.kafka.consumer;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @KafkaListener(topics = "test-topic", concurrency = "4")
  public void consume(final List<String> messages) {
    messages.forEach(
        m -> System.out.println("Consumed(" + Thread.currentThread().getName() + "):" + m));
  }
}
