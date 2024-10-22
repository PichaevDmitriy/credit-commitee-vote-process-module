package uz.keysoft.processmodules.camundaprocessadapter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.community.rest.client.api.MessageApi;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.dto.ProcessInstanceWithVariablesDto;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class ProcessServiceImp implements ProcessService {
  private final MessageApi messageApi;
  private final ProcessDefinitionApi processDefinitionApi;

  @Value("${camunda.bpm.client.tenantId}")
  private String tenantId;


  @Override
  public ProcessInstanceWithVariablesDto start() {
    log.info("Starting process for application {}");
    final StartProcessInstanceDto dto = buildStartProcessDto();
    final ProcessInstanceWithVariablesDto processInstance;
    try {
      return processDefinitionApi.startProcessInstanceByKeyAndTenantId("test_process_id", tenantId, dto);
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }

  private StartProcessInstanceDto buildStartProcessDto() {
    final StartProcessInstanceDto dto = new StartProcessInstanceDto();
    final Map<String, VariableValueDto> vars = new HashMap<>();
    dto.setVariables(vars);
    return dto;
  }
}
