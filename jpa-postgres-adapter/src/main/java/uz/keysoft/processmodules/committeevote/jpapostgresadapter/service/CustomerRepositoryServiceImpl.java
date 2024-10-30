package uz.keysoft.processmodules.committeevote.jpapostgresadapter.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uz.keysoft.processmodules.committeevote.domain.exception.imps.CustomerNotFoundException;
import uz.keysoft.processmodules.committeevote.domain.dto.model.Customer;
import uz.keysoft.processmodules.committeevote.domain.service.repository.CustomerRepositoryService;
import uz.keysoft.processmodules.committeevote.jpapostgresadapter.entity.imps.CustomerEntity;
import uz.keysoft.processmodules.committeevote.jpapostgresadapter.repository.CustomerRepository;

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
    final CustomerEntity entity = toEntity(customer);
    repository.save(entity);
    return toModel(entity);
  }
  @Override
  public Customer findById(final Long id) {
    final CustomerEntity entity = repository.findById(id).orElseThrow(CustomerNotFoundException::new);
    return toModel(entity);
  }

  private Customer toModel(final CustomerEntity entity) {
    return mapper.map(entity, Customer.class);
  }

  private CustomerEntity toEntity(final Customer customer) {
    return mapper.map(customer, CustomerEntity.class);
  }
}
