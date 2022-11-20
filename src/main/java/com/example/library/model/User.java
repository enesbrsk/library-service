package com.example.library.model;

import com.example.library.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "user")
@SuperBuilder
@NoArgsConstructor
@Data
public class User extends BaseEntity{

    @Column(unique = true)
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;

}
