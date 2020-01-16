package ru.kuper.nemanauth.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kuper.nemanauth.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String name);

}
