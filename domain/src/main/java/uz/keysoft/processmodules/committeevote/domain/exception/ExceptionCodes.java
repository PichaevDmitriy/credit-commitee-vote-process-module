package uz.keysoft.processmodules.committeevote.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCodes {
  CUSTOMER_NOT_FOUND_EXCEPTION(10001, "Customer not found");


  private final int code;
  private final String message;

}
