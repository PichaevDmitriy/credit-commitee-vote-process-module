package uz.keysoft.processmodules.domain.service.repository;

import uz.keysoft.processmodules.domain.dto.model.Customer;

public interface CustomerRepositoryService {
  Customer save(Customer customer);
  Customer findById(Long id);
}
