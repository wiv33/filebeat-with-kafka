package org.psawesome.filebeatforkafka.config;

import kafka.zk.KafkaZkClient;
import kafka.zookeeper.ZooKeeperClient;
import org.apache.kafka.streams.processor.internals.DefaultKafkaClientSupplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.ReceiverOffset;
import reactor.kafka.receiver.ReceiverRecord;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
class KafkaManagerTest {

  @Test
  void testKafkaConnection() {
    final ReceiverOffset offset = mock(ReceiverOffset.class);

//    doNothing 이후 offset 관련 호출은 없다.
    doNothing().when(offset).acknowledge(); //  offset과 연결

    @SuppressWarnings("unchecked")
    final ReceiverRecord<String, String> record = mock(ReceiverRecord.class);

    Mockito.when(record.key()).thenReturn(null);
    Mockito.when(record.value()).thenReturn("psawesome");

    final KafkaManager manager = mock(KafkaManager.class);
    Mockito.when(manager.producer(Mockito.any())).thenReturn(Flux.empty());
    Mockito.when(manager.consumer("ps-topic")).thenReturn(Flux.just(record));
  }

  
}