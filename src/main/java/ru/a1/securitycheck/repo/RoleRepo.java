package ru.a1.securitycheck.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.a1.securitycheck.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findRoleByName (String name);



}
