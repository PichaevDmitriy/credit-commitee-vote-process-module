package uz.keysoft.processmodules.committeevote.domain.exception;

public abstract class NotFoundException extends AbstractBusinessLogicException {
  private final int code;
  private final String message;

  protected NotFoundException(final int code, final String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public int getCode() {
    return this.code;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
