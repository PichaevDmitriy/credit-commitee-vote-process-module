package uz.keysoft.processmodules.committeevote.jpapostgresadapter.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableAutoConfiguration
@AllArgsConstructor
@ComponentScan("uz.keysoft.processmodules.committeevote.jpapostgresadapter")
@EnableJpaRepositories(basePackages="uz.keysoft.processmodules.committeevote.jpapostgresadapter")
public class JpaTestConfig {
}
