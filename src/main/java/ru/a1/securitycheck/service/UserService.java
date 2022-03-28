package ru.a1.securitycheck.service;

import ru.a1.securitycheck.entity.Role;
import ru.a1.securitycheck.entity.User;

import java.util.List;

public interface UserService {

    User saveUser (User user);
    Role saveRole (Role role);
    void addRoleToUser (String userName,String roleName);
    User getUser (String userName) ;
    List<User> getUsers();


}
