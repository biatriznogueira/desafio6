package br.com.edusync.Spring.Repository;

import java.util.Optional;

public interface UserRepository {

    Optional<Object> findByUserName(String userName);

    void save(Object user);

}
