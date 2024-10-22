package uz.keysoft.processmodules.camundaprocessadapter.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import uz.keysoft.commons.utils.properties.YamlPropertySourceFactory;

@Configuration
@PropertySource(value = "classpath:camundaProcessAdapter.yml", factory = YamlPropertySourceFactory.class)
@Data
@ConfigurationProperties(prefix = "process-adaptor")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CamundaProcessConfig {
  Retry retry;
  String sourceSystem;
  String timeToExpire;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Retry{
    Integer count;
    Integer timeoutInMilliseconds;
  }
}
