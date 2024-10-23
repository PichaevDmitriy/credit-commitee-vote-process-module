package uz.keysoft.processmodules.camundaprocessadapter.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import uz.keysoft.commons.tests.camunda.RemoteEngineEnvInitializer;
import uz.keysoft.commons.tests.camunda.RemoteEngineExtension;
import uz.keysoft.processmodules.domain.config.ModelMapperConfig;

@ExtendWith(RemoteEngineExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
  classes = {CamundaTestConfig.class,
    ModelMapperConfig.class})
@ContextConfiguration(initializers = RemoteEngineEnvInitializer.class)
public class AbstractProcessTest {
}
