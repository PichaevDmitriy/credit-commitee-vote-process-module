package uz.keysoft.processmodules.committeevote.domain.service.repository;

import uz.keysoft.processmodules.committeevote.domain.dto.model.Customer;

public interface CustomerRepositoryService {
  Customer save(Customer customer);
  Customer findById(Long id);
}
