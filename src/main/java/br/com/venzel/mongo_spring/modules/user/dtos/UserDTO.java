package br.com.venzel.mongo_spring.modules.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
    private String id;

    private String name;

    private String email;
}
