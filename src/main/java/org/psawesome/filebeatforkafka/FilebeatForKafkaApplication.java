package org.psawesome.filebeatforkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class FilebeatForKafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(FilebeatForKafkaApplication.class, args);
  }

  @Bean
  CommandLineRunner runner() {
    return args -> {
      Flux.generate(sink -> sink.next(ThreadLocalRandom.current().nextInt()))
              .delayElements(Duration.ofSeconds(1))
              .index()
              .timestamp()
              .log()
              .subscribe();
      log.info("Hello ps world!!!");
    };
  }
}
