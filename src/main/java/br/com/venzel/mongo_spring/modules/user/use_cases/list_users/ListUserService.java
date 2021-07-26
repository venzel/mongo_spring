package br.com.venzel.mongo_spring.modules.user.use_cases.list_users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.mongo_spring.modules.user.assemblers.UserAssembler;
import br.com.venzel.mongo_spring.modules.user.dtos.UserDTO;
import br.com.venzel.mongo_spring.modules.user.models.User;
import br.com.venzel.mongo_spring.modules.user.repositories.UserRepository;

@Service
public class ListUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserAssembler assembler;
    
    @Transactional
    public List<UserDTO> execute() {

        List<User> users = repository.findAll();
    
        List<UserDTO> usersDTO = assembler.toCollectionModel(users);

        return usersDTO;
    }
}
