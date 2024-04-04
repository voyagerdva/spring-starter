package nn.ru.spring;

import nn.ru.spring.config.ApplicationConfiguration;
import nn.ru.spring.database.pool.ConnectionPool;
import nn.ru.spring.database.repository.CrudRepository;
import nn.ru.spring.service.CompanyService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

public class ApplicationRunner {

    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();

            ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);

            CompanyService companyService = context.getBean(CompanyService.class);
            System.out.println(companyService.findById(1));
        }

    }
}
