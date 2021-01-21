package org.psawesome.elasticstackwithkafka.logback;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateLoggingTests {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Test
  void initElasticAccess() {
    log.info("hello psawesome!!");
  }
}
