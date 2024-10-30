package uz.keysoft.processmodules.committeevote.restadapter.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.keysoft.processmodules.committeevote.domain.dto.model.Customer;
import uz.keysoft.processmodules.committeevote.domain.service.repository.CustomerRepositoryService;
import uz.keysoft.processmodules.committeevote.restadapter.dto.CustomerApi;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/customer")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
  CustomerRepositoryService customerRepositoryServiceService;
  ModelMapper modelMapper;

  @PostMapping("/create")
  public ResponseEntity<CustomerApi> createCustomer(@RequestBody final CustomerApi customer) {
    final Customer customerModel = modelMapper.map(customer, Customer.class);
    final Customer savedCustomer = customerRepositoryServiceService.save(customerModel);
    final CustomerApi result = modelMapper.map(savedCustomer, CustomerApi.class);
    return ResponseEntity.ok(result);
  }
}
