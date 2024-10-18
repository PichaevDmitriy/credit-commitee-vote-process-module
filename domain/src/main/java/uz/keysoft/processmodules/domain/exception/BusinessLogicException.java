package uz.keysoft.processmodules.domain.exception;

public interface BusinessLogicException {
  default int getCode() {
    return 9999;
  }

  String getMessage();
}
