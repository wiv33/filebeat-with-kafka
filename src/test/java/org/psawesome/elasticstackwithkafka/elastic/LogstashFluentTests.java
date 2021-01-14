package org.psawesome.elasticstackwithkafka.elastic;

import org.fluentd.logger.FluentLogger;
import org.fluentd.logger.FluentLoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class LogstashFluentTests {

  @Test
  void testFluentLoggerJava() {
    final FluentLogger LOG = new FluentLoggerFactory().getLogger(getClass().getName(), "localhost", 5005);

    Map<String, Object> data = new HashMap<>();
    data.put("id", "ps in test ");
    data.put("message", "awesome");
    LOG.log("forJava-boot", data);
  }

  final FluentLogger LOG = new FluentLoggerFactory().getLogger(getClass().getName(), "localhost", 5005);

  public void sendLog() {
    LOG.log("forJava",
            Map.of("id", "ps!!!! 33",
                    "name", "Awesome 33 ###",
                    "format", "자유롭군욥")
    );
    LOG.log("forJava",
            Map.of("id", "ps!!!! 33",
                    "format", "자유롭군욥")
    );
  }

  public static void main(String[] args) {
    final LogstashFluentTests tests = new LogstashFluentTests();
    tests.sendLog();
  }
}
