package com.Stars.Stars.config;

import com.Stars.Stars.model.Users;
import com.Stars.Stars.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                password,
                true,
                true,
                true,
                true,

//                user.getIsLocked(),
                user.getAuthorities()
        );
    }





}
