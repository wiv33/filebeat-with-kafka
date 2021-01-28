package org.psawesome.filebeatforkafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

import java.net.InetSocketAddress;

@Configuration
public class ElasticRestConfig extends AbstractReactiveElasticsearchConfiguration {

  @Override
  public ReactiveElasticsearchClient reactiveElasticsearchClient() {
    final ClientConfiguration build = ClientConfiguration.builder()
            .connectedTo(InetSocketAddress.createUnresolved("localhost", 9200))
/*
            .withHeaders(() -> {
              HttpHeaders headers = new HttpHeaders();
              headers.add("ApiKey", "YWtCb3duWuJVTkd1YnlDWWJzMmc6UTVNVlfFRUJRWUdNSmVNeG4zMDEwQQ==");
              headers.add("username", "elastic");
              headers.add("password", "IPPpRPkgy7BdnI9g730Y9ZJt");
              return headers;
            })
*/

            .build();
    return ReactiveRestClients.create(build);
  }
}
