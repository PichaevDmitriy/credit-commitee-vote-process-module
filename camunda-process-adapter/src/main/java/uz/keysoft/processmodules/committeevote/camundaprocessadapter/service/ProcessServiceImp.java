package uz.keysoft.processmodules.committeevote.camundaprocessadapter.service;

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
import uz.keysoft.processmodules.committeevote.domain.dto.process.TestProcessStartResponseDto;
import uz.keysoft.processmodules.committeevote.domain.service.process.TestProcessService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class ProcessServiceImp implements TestProcessService {
  private final MessageApi messageApi;
  private final ProcessDefinitionApi processDefinitionApi;

  @Value("${camunda.bpm.client.tenantId}")
  private String tenantId;


  @Override
  public TestProcessStartResponseDto start(final String processId) {
    log.info("Starting process for application {}");
    final StartProcessInstanceDto dto = buildStartProcessDto();
    try {
      final ProcessInstanceWithVariablesDto processInstance = processDefinitionApi.startProcessInstanceByKeyAndTenantId(processId, tenantId, dto);
      return TestProcessStartResponseDto.builder()
        .id(processInstance.getId())
        .build();
    } catch (final ApiException e) {
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
