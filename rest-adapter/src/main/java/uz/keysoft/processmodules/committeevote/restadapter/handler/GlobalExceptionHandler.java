package uz.keysoft.processmodules.committeevote.restadapter.handler;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.keysoft.commons.model.ErrorsDto;
import uz.keysoft.commons.model.exceptions.AbstractBusinessLogicException;
import uz.keysoft.commons.rest.KeysoftRestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GlobalExceptionHandler extends KeysoftRestControllerAdvice {

  @ResponseStatus(BAD_REQUEST)
  @ExceptionHandler(AbstractBusinessLogicException.class)
  public ErrorsDto handleBadRequestException(final AbstractBusinessLogicException ex) {
    return this.getErrorData(ex.getMessage(), String.valueOf(ex.getCode()), BAD_REQUEST.value());
  }
}
