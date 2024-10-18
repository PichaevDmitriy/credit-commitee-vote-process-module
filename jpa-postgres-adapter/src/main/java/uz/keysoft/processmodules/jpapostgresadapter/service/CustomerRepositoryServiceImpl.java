package uz.keysoft.processmodules.jpapostgresadapter.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uz.keysoft.processmodules.domain.exception.imps.CustomerNotFoundException;
import uz.keysoft.processmodules.domain.model.Customer;
import uz.keysoft.processmodules.domain.repository.CustomerRepositoryService;
import uz.keysoft.processmodules.jpapostgresadapter.entity.imps.CustomerEntity;
import uz.keysoft.processmodules.jpapostgresadapter.repository.CustomerRepository;

@Component
@Slf4j
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomerRepositoryServiceImpl implements CustomerRepositoryService {
  CustomerRepository repository;
  ModelMapper mapper;

  @Override
  public Customer save(final Customer customer) {
    final CustomerEntity entity = mapper.map(customer, CustomerEntity.class);
    repository.save(entity);
    return mapper.map(entity, Customer.class);
  }

  @Override
  public Customer findById(final Long id) {
    final CustomerEntity entity = repository.findById(id).orElseThrow(CustomerNotFoundException::new);
    return mapper.map(entity, Customer.class);
  }
}
