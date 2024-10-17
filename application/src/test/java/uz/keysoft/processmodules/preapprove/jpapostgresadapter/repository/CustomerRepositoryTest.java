package uz.keysoft.processmodules.preapprove.jpapostgresadapter.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uz.keysoft.processmodules.jpapostgresadapter.entity.imps.CustomerEntity;
import uz.keysoft.processmodules.jpapostgresadapter.repository.CustomerRepository;
import uz.keysoft.processmodules.preapprove.AbstractTestContainerInitializer;

public class CustomerRepositoryTest extends AbstractTestContainerInitializer {
  @Autowired
  CustomerRepository customerRepository;

  @Test
  public void saveAndFind() {
    CustomerEntity applicationEntity = CustomerEntity.builder()
      .firstName("First Name")
      .lastName("Last Name")
      .build();

    CustomerEntity saved = customerRepository.save(applicationEntity);
    CustomerEntity found = customerRepository.findById(saved.getId()).get();

    assertEquals(applicationEntity, found);
  }

}