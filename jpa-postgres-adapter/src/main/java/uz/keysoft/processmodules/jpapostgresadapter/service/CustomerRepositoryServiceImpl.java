package uz.keysoft.processmodules.jpapostgresadapter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.keysoft.processmodules.domain.dto.Customer;
import uz.keysoft.processmodules.domain.repository.CustomerRepositoryService;
import uz.keysoft.processmodules.jpapostgresadapter.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerRepositoryServiceImpl implements CustomerRepositoryService {
  private final CustomerRepository customerRepository;

  @Override
  public Customer save(final Customer customer) {
    return null;
  }

  @Override
  public Customer findById(final Long id) {
    return null;
  }
}
