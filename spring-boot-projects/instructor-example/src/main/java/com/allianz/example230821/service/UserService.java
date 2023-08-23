package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.RoleEntity;
import com.allianz.example230821.database.entity.UserEntity;
import com.allianz.example230821.database.repository.RoleEntityRepository;
import com.allianz.example230821.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveUserByRole(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("user").get());
        user.setRoles(roles);
        userRepository.save(user);
    }


}
