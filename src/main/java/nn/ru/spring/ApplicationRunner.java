package nn.ru.spring;

import nn.ru.spring.database.pool.ConnectionPool;
import nn.ru.spring.database.repository.CompanyRepository;
import nn.ru.spring.database.repository.UserRepository;
import nn.ru.spring.ioc.Container;
import nn.ru.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            ConnectionPool connectionPool = context.getBean("p1", ConnectionPool.class);
            System.out.println(connectionPool);

            CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
            System.out.println(companyRepository);
        }

    }
}
