package com.Stars.Stars.controller;



import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UsersService usersService;


    @GetMapping("/findAll")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UserResponse register() {
        return usersService.findAllUsers();
    }

}
