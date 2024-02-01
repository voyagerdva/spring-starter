package nn.ru.spring;

import nn.ru.spring.database.pool.ConnectionPool;
import nn.ru.spring.database.repository.CrudRepository;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

public class ApplicationRunner {

    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            ConnectionPool connectionPool = context.getBean("p1", ConnectionPool.class);
            System.out.println(connectionPool);

            CrudRepository companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }

    }
}
