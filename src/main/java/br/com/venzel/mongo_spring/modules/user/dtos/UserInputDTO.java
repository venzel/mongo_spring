package br.com.venzel.mongo_spring.modules.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDTO {
    
    private String name;

    private String email;
}
