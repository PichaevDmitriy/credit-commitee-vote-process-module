package uz.keysoft.processmodules.preapprove.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages = "uz.keysoft.processmodules.preapprove")
public class PreApproveApplication {
  public static void main(final String[] args) {
    SpringApplication.run(PreApproveApplication.class, args);
  }

}
