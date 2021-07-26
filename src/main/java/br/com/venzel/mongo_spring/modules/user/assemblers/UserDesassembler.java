package br.com.venzel.mongo_spring.modules.user.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.mongo_spring.modules.user.dtos.UserInputDTO;
import br.com.venzel.mongo_spring.modules.user.models.User;

@Component
public class UserDesassembler {

    @Autowired
    private ModelMapper modelMapper;

    public User toDomainObject(UserInputDTO userInputDTO) {
        return modelMapper.map(userInputDTO, User.class);
    }

    public void toCopyDomain(UserInputDTO userInputDTO, User user) {
        modelMapper.map(userInputDTO, user);
    }
}
