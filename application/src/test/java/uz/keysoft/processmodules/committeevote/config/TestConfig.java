package uz.keysoft.processmodules.committeevote.config;

import lombok.AllArgsConstructor;
import org.camunda.community.rest.client.api.MessageApi;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.invoker.ApiClient;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootConfiguration
@EnableAutoConfiguration
@AllArgsConstructor
@ComponentScan("uz.keysoft.processmodules")
@EnableJpaRepositories(basePackages="uz.keysoft.processmodules")
@MockBeans({
  @MockBean(classes = MessageApi.class),
  @MockBean(classes = ApiClient.class),
  @MockBean(classes = ProcessDefinitionApi.class)
})
public class TestConfig {
}

