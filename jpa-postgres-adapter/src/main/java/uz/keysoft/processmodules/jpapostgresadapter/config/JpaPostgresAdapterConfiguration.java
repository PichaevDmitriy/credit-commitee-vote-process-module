package uz.keysoft.processmodules.jpapostgresadapter.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import uz.keysoft.commons.utils.properties.YamlPropertySourceFactory;

@Configuration
@RequiredArgsConstructor
@EntityScan(basePackages = {"uz.keysoft.processmodules.jpapostgresadapter"})
@EnableJpaRepositories(basePackages = {"uz.keysoft.processmodules.jpapostgresadapter"})
@PropertySource(value = "classpath:jpaAdapter.yml", factory = YamlPropertySourceFactory.class)
public class JpaPostgresAdapterConfiguration {
}
