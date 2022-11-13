package com.example.library.dto;


import com.example.library.model.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    private String username;
    private Role role;
    private Long id;


}

