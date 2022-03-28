package ru.a1.securitycheck.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.a1.securitycheck.entity.Role;
import ru.a1.securitycheck.entity.User;
import ru.a1.securitycheck.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }


    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        var uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/addRoleToUser")
    public ResponseEntity<Role> saveUser(@RequestBody RoleToUserForm form) {
       userService.addRoleToUser(form.getUserName(),form.getRoleName());
        return ResponseEntity.ok().build();
    }


}

@Data
class RoleToUserForm {
    private String userName;
    private String roleName;
}