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

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ExternalTaskSubscription("create_vote_task")
public class CreateVoteHandler implements ExternalTaskHandler {
  @Override
  public void execute(final ExternalTask externalTask, final ExternalTaskService externalTaskService) {
    externalTaskService.complete(externalTask);
  }
}
