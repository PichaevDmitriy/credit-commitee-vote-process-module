package uz.keysoft.processmodules.jpapostgresadapter.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableAutoConfiguration
@AllArgsConstructor
@ComponentScan("uz.keysoft.processmodules.jpapostgresadapter")
@EnableJpaRepositories(basePackages="uz.keysoft.processmodules.jpapostgresadapter")
public class TestBeansConfiguration {
}
