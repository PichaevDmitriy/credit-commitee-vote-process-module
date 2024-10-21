package uz.keysoft.processmodules.restadapter.controller;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import uz.keysoft.processmodules.domain.config.ModelMapperConfig;
import uz.keysoft.processmodules.domain.model.Customer;
import uz.keysoft.processmodules.domain.repository.CustomerRepositoryService;
import uz.keysoft.processmodules.restadapter.config.RestAdapterTestConfig;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ModelMapperConfig.class, RestAdapterTestConfig.class})
class CustomerControllerTest {
  @Autowired
  private MockMvc mvc;

  @MockBean(name = "customerRepositoryService")
  private CustomerRepositoryService customerRepositoryService;

  @Test
  void createCustomer() throws Exception {
    doReturn(Customer.builder()
      .id(1l)
      .lastName("lastName")
      .firstName("firstName")
      .build())
      .when(customerRepositoryService)
      .save(any())
    ;

    mvc.perform(post("/api/v1/customer/create")
        .contentType(MediaType.APPLICATION_JSON)
        .content(saveRequest))
      .andExpect(status().isOk())
      .andDo(print());

  }


  private String saveRequest = "{\n" +
    "    \"firstName\" : \"Joe\",\n" +
    "    \"lastName\" : \"Dou\"\n" +
    "}";
}