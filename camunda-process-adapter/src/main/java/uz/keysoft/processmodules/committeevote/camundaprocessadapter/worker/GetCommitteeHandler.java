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

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ExternalTaskSubscription("get_committee_task")
public class GetCommitteeHandler implements ExternalTaskHandler {
  @Override
  public void execute(final ExternalTask externalTask, final ExternalTaskService externalTaskService) {
    final List<String> committeeList = List.of("c1", "c2", "c3");

    Map<String, Object> variables = Map.of("committeeList", committeeList);
    externalTaskService.complete(externalTask, variables);
  }
}
