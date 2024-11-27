package uz.keysoft.processmodules.committeevote.camundaprocessadapter.worker;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ExternalTaskSubscription("make_committee_decision_task")
public class MakeCommitteeDecisionTask implements ExternalTaskHandler {
  @Override
  public void execute(final ExternalTask externalTask, final ExternalTaskService externalTaskService) {
    final Map<String, Object> vars = externalTask.getAllVariables();
    externalTaskService.complete(externalTask);
  }
}
