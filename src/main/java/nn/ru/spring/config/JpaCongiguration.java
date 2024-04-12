
package nn.ru.spring.config;

import lombok.extern.slf4j.Slf4j;
import nn.ru.spring.config.condition.JpaCondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Conditional(JpaCondition.class)
@Configuration
public class JpaCongiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties() {
//        return new DatabaseProperties();
//    }


    @PostConstruct
    void init() {
        log.info("Jpa configuration is enabled");
    }
}
