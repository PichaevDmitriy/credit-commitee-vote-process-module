package uz.keysoft.processmodules.preapprove.domain.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uz.keysoft.processmodules.domain.dto.model.Customer;
import uz.keysoft.processmodules.domain.service.repository.CustomerRepositoryService;
import uz.keysoft.processmodules.preapprove.AbstractTestContainerInitializer;

public class CustomerRepositoryServiceTest extends AbstractTestContainerInitializer {
  @Autowired
  CustomerRepositoryService customerRepositoryService;

  @Test
  public void saveAndFindCustomer() {
    Customer customer = Customer.builder()
      .firstName("John")
      .lastName("Doe")
      .build();

    Customer savedCustomer = customerRepositoryService.save(customer);
    assertNotNull(savedCustomer.getId());
    Customer foundCustomer = customerRepositoryService.findById(savedCustomer.getId());

    assertEquals(savedCustomer, foundCustomer);
  }
}
