package es.com.cloudftic.microservices.pcfutbolcore.configurations;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Data
@Configuration
@ConfigurationProperties(prefix = "server")
public class ApiInfo {

    @Value("${name}")
    private String name;

    @Value("${capital}")
    private BigDecimal capital;

}
