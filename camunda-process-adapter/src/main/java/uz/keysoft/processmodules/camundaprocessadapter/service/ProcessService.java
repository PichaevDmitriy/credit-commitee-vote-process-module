package uz.keysoft.processmodules.camundaprocessadapter.service;

import org.camunda.community.rest.client.dto.ProcessInstanceWithVariablesDto;

public interface ProcessService {
  ProcessInstanceWithVariablesDto start();
}
