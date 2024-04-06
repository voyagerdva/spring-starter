
package nn.ru.spring.config;

import nn.ru.spring.config.condition.JpaCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(JpaCondition.class)
@Configuration
public class JpaCongiguration {

    @PostConstruct
    void init() {
        System.out.println("Jpa configuration is enabled");
    }
}