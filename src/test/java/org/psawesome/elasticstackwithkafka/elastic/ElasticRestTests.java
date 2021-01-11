package org.psawesome.elasticstackwithkafka.elastic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ElasticRestTests {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Test
  void initElasticAccess() {
    System.out.println(log.getName());
    log.info("hello world!");
  }
}
