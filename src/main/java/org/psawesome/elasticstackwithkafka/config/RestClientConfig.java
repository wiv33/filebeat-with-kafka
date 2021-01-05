package org.psawesome.elasticstackwithkafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

import java.net.InetSocketAddress;

@Configuration
public class RestClientConfig extends AbstractReactiveElasticsearchConfiguration {

  @Override
  public ReactiveElasticsearchClient reactiveElasticsearchClient() {
    final ClientConfiguration build = ClientConfiguration.builder()
            .connectedTo(InetSocketAddress.createUnresolved("https://6da07aa5a600438794bea666fc798358.ap-northeast-2.aws.elastic-cloud.com", 9243))
            .withHeaders(() -> {
              HttpHeaders headers = new HttpHeaders();
              headers.add("ApiKey", "YWtCb3duWuJVTkd1YnlDWWJzMmc6UTVNVlfFRUJRWUdNSmVNeG4zMDEwQQ==");
              headers.add("username", "elastic");
              headers.add("password", "IPPpRPkgy7BdnI9g730Y9ZJt");
              return headers;
            })

            .build();
    return ReactiveRestClients.create(build);
  }
}
