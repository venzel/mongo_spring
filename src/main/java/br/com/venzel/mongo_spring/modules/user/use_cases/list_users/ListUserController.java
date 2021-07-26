package br.com.venzel.mongo_spring.modules.user.use_cases.list_users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.mongo_spring.modules.user.dtos.UserDTO;

@RestController
@RequestMapping("/users")
public class ListUserController {

    @Autowired
    private ListUserService service;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> handle() {

        List<UserDTO> users = service.execute();

        return users;
    }
}
