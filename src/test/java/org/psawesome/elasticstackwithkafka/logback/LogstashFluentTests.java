package org.psawesome.elasticstackwithkafka.logback;

import org.fluentd.logger.FluentLogger;
import org.fluentd.logger.FluentLoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class LogstashFluentTests {

  @Test
  void testFluentLoggerJava() {
    final FluentLogger LOG = new FluentLoggerFactory().getLogger(getClass().getName(), "35.216.73.222", 5005);

    Map<String, Object> data = new HashMap<>();
    data.put("id", "ps in test ");
    data.put("message", "awesome");
    LOG.log("forJava-boot", data);
  }

  final FluentLogger log = new FluentLoggerFactory().getLogger(getClass().getName(), "35.216.73.222", 5005);

  public void sendLog() {
    try {
      if (true) {
        throw new RuntimeException("ps error");
      }
    } catch (RuntimeException e) {
      final StringBuilder reduce = Arrays.stream(e.getStackTrace())
              .map(StackTraceElement::toString)
              .reduce(new StringBuilder("\r\n"), (stringBuilder, str) -> stringBuilder.append(str).append("\r\n"), StringBuilder::append);
      log.log("ERROR",
              Map.of(
              "errorMessage", e.getMessage(),
              "stackTrace", reduce)
      );
    }

    log.log("forJava",
            Map.of("id", "ps!!!! 33",
                    "name", "Awesome 33 ###",
                    "ttyy", "first",
                    "format", "자유롭군욥 3")
    );
    log.log("forJava",
            Map.of("id", "ps!!!! 33",
                    "format", "자유롭군욥 4")
    );
  }

  public static void main(String[] args) {
    final LogstashFluentTests tests = new LogstashFluentTests();
    tests.sendLog();
  }
}
