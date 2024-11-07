package uz.keysoft.processmodules.committeevote.camundaprocessadapter.worker;

import org.camunda.community.rest.client.dto.HistoricProcessInstanceDto;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.shaded.org.awaitility.Awaitility;
import uz.keysoft.commons.tests.camunda.RemoteDeployment;
import uz.keysoft.commons.tests.camunda.RemoteEngineUtils;
import uz.keysoft.processmodules.committeevote.camundaprocessadapter.config.AbstractProcessTest;
import uz.keysoft.processmodules.committeevote.domain.service.process.TestProcessService;

import java.util.List;
import java.util.UUID;

@RemoteDeployment(resources = "processes/testProcess.bpmn")
class TestHandlerTest extends AbstractProcessTest {
  @Autowired
  TestProcessService processService;

  @Test
  void executeTestProcess_happyPath() {
    Long claimId = 1L;
    String businessKey = UUID.randomUUID().toString();
    String processInstanceId = processService.start("test_process_id").getId();
    assertNotNull(processInstanceId);
    List<HistoricProcessInstanceDto> processInstances = RemoteEngineUtils.getHistoricProcessInstances(businessKey);
    Awaitility.await().until(() -> !RemoteEngineUtils.getAwaitedMessagesNames(processInstanceId).isEmpty());
//    processService.sendGoDecisionMessage(businessKey, claimId, Decision.HQ_APPROVED);
//    assertEquals(1, processInstances.size());
//    assertEquals(processInstanceId, processInstances.get(0).getId());
//    assertEquals(businessKey, processInstances.get(0).getBusinessKey());
//    Awaitility.await().until(() -> RemoteEngineUtils.allInstancesAreCompleted(businessKey));
//    verify(applicationService, times(1)).updateState(claimId, State.FINISHED);

  }

}