package uz.keysoft.processmodules.committeevote.camundaprocessadapter.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Service;
import uz.keysoft.processmodules.committeevote.camundaprocessadapter.dto.CommitteeMemberProcess;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ExternalTaskSubscription("create_vote_task")
public class CreateVoteHandler implements ExternalTaskHandler {
  ObjectMapper mapper;

  @Override
  public void execute(final ExternalTask externalTask, final ExternalTaskService externalTaskService) {
    final Map<String, Object> vars =  externalTask.getAllVariables();
    final String json = (String) vars.get("committeeMember");
    try {
      final CommitteeMemberProcess committeeMember = mapper.readValue(json, CommitteeMemberProcess.class);
      final String name = committeeMember.getFirstName();
    } catch (final JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    externalTaskService.complete(externalTask);
  }
}
