package org.psawesome.filebeatforkafka;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@SpringBootApplication
public class FilebeatForKafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(FilebeatForKafkaApplication.class, args);
  }

  @Bean
  CommandLineRunner runner() {
    return args -> {
      Flux.generate(sink -> sink.next(new StockInfo()))
              .delayElements(Duration.ofMillis(333))
              .index()
              .log()
              .subscribe();
      log.info("Hello ps world!!!");
    };
  }

}

@ToString
@EqualsAndHashCode
@Getter(AccessLevel.PACKAGE)
class StockInfo {

  private final String title;
  private final int price;
  private final LocalDateTime dateTime;

  public StockInfo() {
    this.title = defaultTitle();
    this.price = defaultPrice();
    this.dateTime = LocalDateTime.now();
  }

  private String defaultTitle() {
    var titleList = List.of("삼성전자", "현대모비스", "키움증권", "신세계", "삼성SDI");
    return titleList.get(ThreadLocalRandom.current().nextInt(titleList.size() - 1));
  }

  private int defaultPrice() {
    return ThreadLocalRandom.current().nextInt(-300_000, 300_000);
  }
}