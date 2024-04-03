package nn.ru.spring.service;

import nn.ru.spring.bpp.Auditing;
import nn.ru.spring.bpp.Second;
import nn.ru.spring.bpp.Transaction;
import nn.ru.spring.database.repository.CompanyRepository;
import nn.ru.spring.database.repository.UserRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Transaction
//@Auditing
//@Second
public class CompanyService {

    private final UserService userService;

    public CompanyService(UserService userService) {
        this.userService = userService;
    }
}
