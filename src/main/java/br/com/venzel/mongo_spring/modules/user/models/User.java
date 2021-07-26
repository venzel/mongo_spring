package br.com.venzel.mongo_spring.modules.user.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
@Document(collection = "user")
public class User {
    
    @Id
    private String id;

    private String name;

    private String email;
}
