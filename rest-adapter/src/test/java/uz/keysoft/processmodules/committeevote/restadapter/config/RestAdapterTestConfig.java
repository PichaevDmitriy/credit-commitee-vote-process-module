package uz.keysoft.processmodules.committeevote.restadapter.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootConfiguration
@EnableAutoConfiguration
@AllArgsConstructor
@ComponentScan("uz.keysoft.processmodules.committeevote.restadapter")
public class RestAdapterTestConfig {
}

