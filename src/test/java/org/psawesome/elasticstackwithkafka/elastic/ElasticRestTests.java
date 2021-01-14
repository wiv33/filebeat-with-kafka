package org.psawesome.elasticstackwithkafka.elastic;

import org.fluentd.logger.FluentLogger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class ElasticRestTests {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Test
  void initElasticAccess() {
    System.out.println(log.getName());
    log.info("hello psawesome!!");
  }
}
