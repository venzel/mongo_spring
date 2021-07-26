package br.com.venzel.mongo_spring.modules.user.assemblers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.mongo_spring.modules.user.dtos.UserDTO;
import br.com.venzel.mongo_spring.modules.user.models.User;

@Component
public class UserAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toModel(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> toCollectionModel(List<User> users) {
        return users.stream()
                    .map(e -> toModel(e))
                    .collect(Collectors.toList());
    }
}
