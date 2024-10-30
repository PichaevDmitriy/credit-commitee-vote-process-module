package uz.keysoft.processmodules.committeevote.domain.exception;

public interface BusinessLogicException {
  default int getCode() {
    return 9999;
  }

  String getMessage();
}
