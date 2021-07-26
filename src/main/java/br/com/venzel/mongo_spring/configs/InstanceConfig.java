package br.com.venzel.mongo_spring.configs;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.venzel.mongo_spring.modules.user.models.User;
import br.com.venzel.mongo_spring.modules.user.repositories.UserRepository;

@Configuration
public class InstanceConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User alex = new User(null, "Alex", "alex@gmail.com");
        User tiago = new User(null, "Tiago", "tiago@gmail.com");
        User liz = new User(null, "Liz", "liz@gmail.com");

        userRepository.saveAll(Arrays.asList(alex, tiago, liz));
    }
}
