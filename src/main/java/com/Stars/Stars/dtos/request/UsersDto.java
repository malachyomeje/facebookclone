package com.Stars.Stars.dtos.request;

import com.Stars.Stars.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private String firstName;
    private String lastName ;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
}
