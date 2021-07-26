package br.com.venzel.mongo_spring.modules.user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.mongo_spring.modules.user.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findOneById(String id);

    Optional<User> findOneByEmail(String email);

    Optional<User> findOneByName(String name);
    
    List<User> findAllByNameContaining(String name);

    Optional<User> findFirstByNameContaining(String name);

    List<User> findTop5ByNameContaining(String name);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    Integer countByName(String name);
}
