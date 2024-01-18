package nn.ru.spring.database.repository;

import nn.ru.spring.database.pool.ConnectionPool;
public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
