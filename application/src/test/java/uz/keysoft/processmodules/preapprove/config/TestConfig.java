package uz.keysoft.processmodules.preapprove.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootConfiguration
@EnableAutoConfiguration
@AllArgsConstructor
@ComponentScan("uz.keysoft.processmodules")
@EnableJpaRepositories(basePackages="uz.keysoft.processmodules")
public class TestConfig {
}
