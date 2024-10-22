package uz.keysoft.processmodules.camundaprocessadapter.worker;

import org.camunda.community.rest.client.dto.HistoricProcessInstanceDto;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import uz.keysoft.commons.tests.camunda.RemoteDeployment;
import uz.keysoft.commons.tests.camunda.RemoteEngineEnvInitializer;
import uz.keysoft.commons.tests.camunda.RemoteEngineExtension;
import uz.keysoft.commons.tests.camunda.RemoteEngineUtils;
import uz.keysoft.processmodules.camundaprocessadapter.config.CamundaTestConfiguration;
import uz.keysoft.processmodules.camundaprocessadapter.service.ProcessService;

import java.util.List;
import java.util.UUID;

@RemoteDeployment(resources = "processes/testProcess.bpmn")
@ExtendWith(RemoteEngineExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
  classes = CamundaTestConfiguration.class)
@ContextConfiguration(initializers = RemoteEngineEnvInitializer.class)
class TestHandlerTest {
  @Autowired
  ProcessService processService;

  @Test
  void executeOnlineInsuranceProcess_happyPath() {
    Long claimId = 1L;
    String businessKey = UUID.randomUUID().toString();
    String processInstanceId = processService.start().getId();
    assertNotNull(processInstanceId);
    List<HistoricProcessInstanceDto> processInstances = RemoteEngineUtils.getHistoricProcessInstances(businessKey);
//    Awaitility.await().until(() -> !RemoteEngineUtils.getAwaitedMessagesNames(processInstanceId).isEmpty());
//    processService.sendGoDecisionMessage(businessKey, claimId, Decision.HQ_APPROVED);
//    assertEquals(1, processInstances.size());
//    assertEquals(processInstanceId, processInstances.get(0).getId());
//    assertEquals(businessKey, processInstances.get(0).getBusinessKey());
//    Awaitility.await().until(() -> RemoteEngineUtils.allInstancesAreCompleted(businessKey));
//    verify(applicationService, times(1)).updateState(claimId, State.FINISHED);

  }

}