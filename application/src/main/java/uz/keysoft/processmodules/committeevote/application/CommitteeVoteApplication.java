package uz.keysoft.processmodules.committeevote.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication(scanBasePackages = "uz.keysoft.processmodules.preapprove")
public class CommitteeVoteApplication {
  public static void main(final String[] args) {
    SpringApplication.run(CommitteeVoteApplication.class, args);
  }

}
