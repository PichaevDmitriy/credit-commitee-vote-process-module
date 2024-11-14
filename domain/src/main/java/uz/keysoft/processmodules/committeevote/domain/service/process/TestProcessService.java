package uz.keysoft.processmodules.committeevote.domain.service.process;

import uz.keysoft.processmodules.committeevote.domain.dto.process.TestProcessStartResponseDto;

public interface TestProcessService {
  TestProcessStartResponseDto start(String processId);
}
