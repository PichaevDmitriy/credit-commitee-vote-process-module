package uz.keysoft.processmodules.camundaprocessadapter.config;

import org.camunda.community.rest.client.api.MessageApi;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.springboot.CamundaProcessAutodeployment;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uz.keysoft.commons.tests.camunda.RemoteEngine;

@Configuration
@EnableAutoConfiguration(exclude = {
  CamundaProcessAutodeployment.class,
  DataSourceAutoConfiguration.class,
})
@ComponentScan("uz.keysoft.processmodules.camundaprocessadapter")
public class CamundaTestConfiguration {
  @Bean
  MessageApi getMessageApi(){
    return new MessageApi(RemoteEngine.getApiClient());
  }

  @Bean
  ProcessDefinitionApi getProcessDefinitionApi(){
    return new ProcessDefinitionApi(RemoteEngine.getApiClient());
  }
}