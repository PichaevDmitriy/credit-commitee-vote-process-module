package uz.keysoft.processmodules.domain.repository;

import uz.keysoft.processmodules.domain.dto.Customer;

public interface CustomerRepositoryService {
  Customer save(Customer customer);
  Customer findById(Long id);
}
