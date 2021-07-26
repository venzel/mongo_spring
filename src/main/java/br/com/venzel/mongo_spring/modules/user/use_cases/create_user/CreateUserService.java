package br.com.venzel.mongo_spring.modules.user.use_cases.create_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.mongo_spring.modules.user.assemblers.UserAssembler;
import br.com.venzel.mongo_spring.modules.user.assemblers.UserDesassembler;
import br.com.venzel.mongo_spring.modules.user.dtos.UserDTO;
import br.com.venzel.mongo_spring.modules.user.dtos.UserInputDTO;
import br.com.venzel.mongo_spring.modules.user.models.User;
import br.com.venzel.mongo_spring.modules.user.repositories.UserRepository;

@Service
public class CreateUserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserAssembler assembler;

    @Autowired
    private UserDesassembler desassembler;

    @Transactional
    public UserDTO execute(UserInputDTO userInputDTO) {

        User user = desassembler.toDomainObject(userInputDTO);

        user = repository.save(user);

        UserDTO userDTO = assembler.toModel(user);

        return userDTO;
    }
}
