package nn.ru.spring.database.repository;

import nn.ru.spring.bpp.Auditing;
import nn.ru.spring.bpp.Second;
import nn.ru.spring.bpp.Transaction;
import nn.ru.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Transaction
//@Auditing
//@Second

public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(@Qualifier("pool2") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
