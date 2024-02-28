package nn.ru.spring.service;

import nn.ru.spring.database.repository.CompanyRepository;
import nn.ru.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final UserService userService;

    public CompanyService(UserService userService) {
        this.userService = userService;
    }
}
