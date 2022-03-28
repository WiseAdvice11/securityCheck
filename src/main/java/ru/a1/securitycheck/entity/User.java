package ru.a1.securitycheck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity<Long> {

    private String name;
    private String userName;
    private String password;
    @ManyToMany (fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

}
