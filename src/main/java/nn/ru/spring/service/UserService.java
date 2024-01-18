package nn.ru.spring.service;

import nn.ru.spring.database.repository.CompanyRepository;
import nn.ru.spring.database.repository.UserRepository;
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
