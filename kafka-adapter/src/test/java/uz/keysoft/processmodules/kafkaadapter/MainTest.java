package uz.keysoft.processmodules.kafkaadapter;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import uz.keysoft.processmodules.kafkaadapter.config.KafkaTestConfig;

@Testcontainers
@SpringBootTest(classes = {KafkaTestConfig.class})
class MainTest {

  @Container
  public static KafkaContainer kafka;

  static {
    kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.4.0"));
    kafka.start();
    assertTrue(kafka.isRunning());
  }


  @AfterAll
  public static void cleanUp() {
    kafka.stop();
    assertFalse(kafka.isRunning());
  }

  @DynamicPropertySource
  static void registerKafkaProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.kafka.bootstrap-servers", () -> kafka.getBootstrapServers());
  }

  @Test
  public void testNotificationSending() {
    assertTrue(kafka.isRunning());
    String topicName = "notifications-test";
  }
}