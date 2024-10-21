package uz.keysoft.processmodules.preapprove.restadapter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import uz.keysoft.processmodules.preapprove.AbstractTestContainerInitializer;

@AutoConfigureMockMvc
public class CustomerControllerTest extends AbstractTestContainerInitializer {
  @Autowired
  private MockMvc mvc;


  @Test
  void createCustomer() throws Exception {
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
