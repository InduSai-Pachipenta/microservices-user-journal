
package com.indusai.user_service.service;

import com.indusai.user_service.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUserById(Long id);
    void deleteUser(Long id);
    UserDetails loadUserByUsername(String username);
}
