package ru.a1.securitycheck.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.a1.securitycheck.entity.Role;
import ru.a1.securitycheck.entity.User;
import ru.a1.securitycheck.repo.RoleRepo;
import ru.a1.securitycheck.repo.UserRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepo.findByUserName(username);
      if(Objects.isNull(user)){
          throw new IllegalStateException("User not found");
      }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authorities);
    }

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override

    public User saveUser(User user) {
        log.info("Saving new user {} to the database",user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepo.findByUserName(userName);
        Role role = roleRepo.findRoleByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
