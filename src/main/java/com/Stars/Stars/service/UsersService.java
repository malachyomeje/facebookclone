package com.Stars.Stars.service;

import com.Stars.Stars.dtos.request.AuthenticationDto;
import com.Stars.Stars.dtos.request.LockAccDto;
import com.Stars.Stars.dtos.request.UpdateUsersDto;
import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.dtos.request.UsersDto;

public interface UsersService {


    UserResponse registerUsers(UsersDto usersDto);

    UserResponse authenticate(AuthenticationDto authenticationDto);

    String security();

    UserResponse findAllUsers();


    UserResponse updateUser(UpdateUsersDto updateUsersDto);

    UserResponse logOut();

    UserResponse lockAcc (LockAccDto lockAccDto);
}
