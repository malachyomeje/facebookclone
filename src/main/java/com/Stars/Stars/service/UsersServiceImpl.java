package com.Stars.Stars.service;

import com.Stars.Stars.config.JwtService;
import com.Stars.Stars.dtos.request.AuthenticationDto;
import com.Stars.Stars.dtos.request.LockAccDto;
import com.Stars.Stars.dtos.request.UpdateUsersDto;
import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.dtos.request.UsersDto;
import com.Stars.Stars.model.Users;
import com.Stars.Stars.repository.UsersRepository;
import com.Stars.Stars.verifications.Verifications;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserResponse registerUsers(UsersDto usersDto) {

        Optional<Users> users = usersRepository.findByEmail(usersDto.getEmail());

        if (users.isPresent()) {

            return new UserResponse<>("user already exist", users);
        }

        if (!Verifications.validEmail(usersDto.getEmail())) {
            return new UserResponse<>("wrong email", users);
        }

        if (!Verifications.validPhoneNumber(usersDto.getPhoneNumber())) {

            return new UserResponse<>("wrong phoneNumber", users);
        }

        if (usersDto.getPassword().isEmpty() || usersDto.getPassword().length() < 5) {

            return new UserResponse<>("wrong password", users);
        }

        Users users1 = Users.builder()
                .firstName(usersDto.getFirstName())
                .lastName(usersDto.getLastName())
                .email(usersDto.getEmail())
                .phoneNumber(usersDto.getPhoneNumber())
                .password(passwordEncoder.encode(usersDto.getPassword()))
                .role(usersDto.getRole())
                .build();
        usersRepository.save(users1);

        var jwtToken = jwtService.generateToken(users1);
        return UserResponse.builder()
                .data(jwtToken)
                .message("successful")
                .build();
    }

    @Override
    public UserResponse authenticate(AuthenticationDto authenticationDto) {
       Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.getEmail(),
                        authenticationDto.getPassword()));

        if(auth.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        var user = usersRepository.findByEmail(authenticationDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        System.out.println("user "+user);
        var jwtToken = jwtService.generateToken(user);
        user.setToken(jwtToken);
        usersRepository.save(user);
        return UserResponse.builder()
                .data(jwtToken)
                .message("successful")
                .build();
    }

    @Override
    public String security() {
        return "SPRING SECURITY IS TOO HARD TO UNDERSTAND";
    }

    @Override
    public UserResponse findAllUsers() {
        List<Users> findAll = usersRepository.findAll();
        return UserResponse.builder()
                .data(findAll)
                .message("successful")
                .build();
    }


    public UserResponse updateUser(UpdateUsersDto updateUsersDto) {
        Optional<Users> user = usersRepository.findByEmail(updateUsersDto.getEmail());
        if (user.isEmpty()) {
            return new UserResponse<>("User not found", user);
        }


        Users existingUser = user.get();
        existingUser.setFirstName(updateUsersDto.getFirstName());
        existingUser.setLastName(updateUsersDto.getLastName());
        existingUser.setEmail(updateUsersDto.getEmail());
        existingUser.setPassword(updateUsersDto.getPassword());
        existingUser.setPhoneNumber(updateUsersDto.getPhoneNumber());

        usersRepository.save(existingUser);

        return new UserResponse<>("Updated successfully", existingUser);
    }

@Override

    public UserResponse logOut(){
        String email=SecurityContextHolder.getContext().getAuthentication().getName();
    System.out.println(email);
        Optional<Users> users= usersRepository.findByEmail(email);
        Users users1 =users.get();
        Verifications.blackListedTokens.add(users1.getToken());
        usersRepository.save(users1);

      return new UserResponse<>("user logout",users);
    }

    @Override
public UserResponse lockAcc(LockAccDto lockAccDto){
        Optional<Users> users = usersRepository.findByEmail(lockAccDto.getEmail());
        if (users.isEmpty()){
            return new UserResponse<>("user not found",users);
        }
        Users users1 = users.get();
        users1.setEmail(lockAccDto.getEmail());
        users1.setLocked(false);
        usersRepository.save(users1);
        return  new UserResponse<>("your account has been locked",users1);
}

}

