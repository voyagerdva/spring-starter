package nn.ru.spring.service;

import nn.ru.spring.database.entity.Company;
import nn.ru.spring.database.repository.CompanyRepository;
import nn.ru.spring.database.repository.CrudRepository;
import nn.ru.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
