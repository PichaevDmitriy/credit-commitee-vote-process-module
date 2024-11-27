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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ExternalTaskSubscription("get_committee_task")
public class GetCommitteeHandler implements ExternalTaskHandler {
  ObjectMapper mapper;

  @Override
  public void execute(final ExternalTask externalTask, final ExternalTaskService externalTaskService) {
    //TODO add exception handling
    final CommitteeMemberProcess committeeMember1 = CommitteeMemberProcess.builder()
      .id("1")
      .firstName("John")
      .lastName("Doe")
      .build();
    final CommitteeMemberProcess committeeMember2 = CommitteeMemberProcess.builder()
      .id("2")
      .firstName("Jane")
      .lastName("Doe")
      .build();


    final Collection<String> committeeList = new ArrayList<>();
    try {
      committeeList.add(mapper.writeValueAsString(committeeMember1));
      committeeList.add(mapper.writeValueAsString(committeeMember2));
    } catch (final JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    final Long globalId = 12345L;

    final List<String> testCommitteeIds = List.of(committeeMember1.getId(), committeeMember2.getId());

    final Map<String, Object> variables = Map.of("committeeList", committeeList , "globalId", globalId);

    externalTaskService.complete(externalTask, variables);
  }
}
