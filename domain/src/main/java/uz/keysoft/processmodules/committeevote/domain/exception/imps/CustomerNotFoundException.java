package uz.keysoft.processmodules.committeevote.domain.exception.imps;

import uz.keysoft.processmodules.committeevote.domain.exception.ExceptionCodes;
import uz.keysoft.processmodules.committeevote.domain.exception.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {
  public CustomerNotFoundException() {
    super(ExceptionCodes.CUSTOMER_NOT_FOUND_EXCEPTION.getCode()
      , ExceptionCodes.CUSTOMER_NOT_FOUND_EXCEPTION.getMessage()
    );
  }

}
