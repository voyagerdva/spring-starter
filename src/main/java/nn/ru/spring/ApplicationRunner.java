package nn.ru.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "nn.ru.spring")
//@ComponentScan(basePackages = "nn.ru.spring")
public class ApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println("\ncontext.getBeanDefinitionCount(): " + context.getBeanDefinitionCount() + "\n");
    }
}
