package ru.a1.securitycheck.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.a1.securitycheck.entity.User;

public interface UserRepo extends JpaRepository <User,Long>{

User findByUserName (String username);
}
