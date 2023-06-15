package com.Stars.Stars.controller;

import com.Stars.Stars.dtos.request.AuthenticationDto;
import com.Stars.Stars.dtos.request.LockAccDto;
import com.Stars.Stars.dtos.request.UpdateUsersDto;
import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.dtos.request.UsersDto;
import com.Stars.Stars.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stars")
@RequiredArgsConstructor


public class UsersController {
    private final UsersService usersService;


    @PostMapping("/register")
    public UserResponse register(@RequestBody UsersDto usersDto) {
        return usersService.registerUsers(usersDto);
    }


    @PostMapping("/authenticate")
    public UserResponse authenticate(@RequestBody AuthenticationDto authenticationDto) {
        return usersService.authenticate(authenticationDto);

    }

    @PutMapping("/update")
    public UserResponse update(@RequestBody UpdateUsersDto updateUsersDto) {
        return usersService.updateUser(updateUsersDto);

    }
    @GetMapping("/not")
    public String security() {
        return usersService.security();

    }
    @GetMapping("/logOut")
    public UserResponse logOut(){
        return usersService.logOut();
    }


    @PostMapping("/locked")
    public UserResponse locked(@RequestBody LockAccDto lockAccDto){
        return usersService.lockAcc(lockAccDto);
    }

}