package uz.keysoft.processmodules.domain.exception.imps;

import uz.keysoft.processmodules.domain.exception.ExceptionCodes;
import uz.keysoft.processmodules.domain.exception.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {
  public CustomerNotFoundException() {
    super(ExceptionCodes.CUSTOMER_NOT_FOUND_EXCEPTION.getCode()
      , ExceptionCodes.CUSTOMER_NOT_FOUND_EXCEPTION.getMessage()
    );
  }

}
