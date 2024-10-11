package uz.keysoft.processmodules.preapprove.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import uz.keysoft.processmodules.preapprove.application.config.TestConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Import(TestConfig.class)
class PreApproveApplicationTest {
  @Test
  public void contextLoads() {}

}