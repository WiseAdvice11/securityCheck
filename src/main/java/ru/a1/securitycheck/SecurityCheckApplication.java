package ru.a1.securitycheck;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.a1.securitycheck.entity.Role;
import ru.a1.securitycheck.entity.User;
import ru.a1.securitycheck.service.UserService;

import java.beans.BeanProperty;
import java.util.ArrayList;

@SpringBootApplication
public class SecurityCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityCheckApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder (){

        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {

        return args -> {
            userService.saveUser(new User(null,"Sara","O'Connor","123",new ArrayList<>()));
            userService.saveUser(new User(null,"Jim","Worm","123",   new ArrayList<>()));
            userService.saveUser(new User(null,"Sam","Serious","123",new ArrayList<>()));
            userService.saveUser(new User(null,"John","Week","123",  new ArrayList<>()));

            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.addRoleToUser("O'Connor","ROLE_USER");
            userService.addRoleToUser("Serious","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("Serious","ROLE_ADMIN");
            userService.addRoleToUser("Worm","ROLE_MANAGER");
            userService.addRoleToUser("Week","ROLE_USER");


        };

        }
    }
