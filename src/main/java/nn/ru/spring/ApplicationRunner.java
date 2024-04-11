package nn.ru.spring;

import nn.ru.spring.config.DatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println("\ncontext.getBeanDefinitionCount(): " + context.getBeanDefinitionCount() + "\n");
        System.out.println(context.getBean("pool1"));
        System.out.println("context.getBean(DatabaseProperties.class): " + context.getBean(DatabaseProperties.class));
    }
}
