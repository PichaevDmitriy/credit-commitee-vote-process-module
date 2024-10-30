package uz.keysoft.processmodules.committeevote.config;

import static org.junit.Assert.assertTrue;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TestConfig.class})
public abstract class AbstractIntegrationTest {
  private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:16")
    .withCommand("postgres -c max_connections=255");

  static {
    postgresContainer.start();
    assertTrue(postgresContainer.isRunning());
  }

  @DynamicPropertySource
  private static void setUpDynamicPropertyValues(DynamicPropertyRegistry registry) {
    registry.add("DB_URL", postgresContainer::getJdbcUrl);
    registry.add("DB_USERNAME", postgresContainer::getUsername);
    registry.add("DB_PASSWORD", postgresContainer::getPassword);
    registry.add("CAMUNDA_URL", () -> "test");
    registry.add("CAMUNDA_TENANT_ID", () -> "test");
    registry.add("CRON_ENABLED", () -> false);
  }
}
