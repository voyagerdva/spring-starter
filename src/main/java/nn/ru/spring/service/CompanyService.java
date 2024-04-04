package nn.ru.spring.service;

import nn.ru.spring.database.entity.Company;
import nn.ru.spring.database.repository.CompanyRepository;
import nn.ru.spring.database.repository.CrudRepository;
import nn.ru.spring.database.repository.UserRepository;
import nn.ru.spring.dto.CompanyReadDto;
import nn.ru.spring.listener.entity.AccessType;
import nn.ru.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer, Company> companyRepository,
                          UserService userService,
                          ApplicationEventPublisher eventPublisher) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }

}
