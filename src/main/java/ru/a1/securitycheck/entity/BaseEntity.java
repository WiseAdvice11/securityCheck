package ru.a1.securitycheck.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity <T extends Serializable> {

        @Id
        @GeneratedValue
        private T id;
}
