package com.indusai.user_service.controller;

import com.indusai.user_service.dto.UserEventDTO;
import com.indusai.user_service.model.UserEntity;
import com.indusai.user_service.securityconfig.JwtUtil;
import com.indusai.user_service.service.KafkaProducerService;
import com.indusai.user_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtUtil.generateToken(userDetails.getUsername());
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid credentials", e);
        }
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);

        UserEventDTO event = new UserEventDTO();
        event.setUserId(createdUser.getId());
        event.setUsername(createdUser.getUsername());
        event.setAction("USER_CREATED");
       // event.setTimestamp(new Date());
        event.setTimestamp(new Date().toString());

        //event.setTimestamp(new Date());


        kafkaProducerService.sendUserEvent(event);

        return createdUser;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
