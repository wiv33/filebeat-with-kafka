package org.psawesome.elasticstackwithkafka.elastic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;

@SpringBootTest
public class ElasticRestTests {

  @Autowired
  ReactiveElasticsearchClient highLevelClient;

  @Test
  void initElasticAccess() {
    highLevelClient.index()
  }
}
