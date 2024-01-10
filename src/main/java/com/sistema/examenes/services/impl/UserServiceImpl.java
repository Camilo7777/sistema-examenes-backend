package com.sistema.examenes.services.impl;

import com.sistema.examenes.models.User;
import com.sistema.examenes.models.UserRol;
import com.sistema.examenes.repositories.RolRepository;
import com.sistema.examenes.repositories.UserRepository;
import com.sistema.examenes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user, Set<UserRol> userRolSet) throws Exception {
        User userAux = userRepository.findByUserName(user.getUserName());
        if (userAux != null){
            System.out.println("User already exists");
            throw new Exception("The user already exists");
        }
        for (UserRol userRol:userRolSet) {
          rolRepository.save(userRol.getRol());
        }
        user.getUserRoles().addAll(userRolSet);
        return  userRepository.save(user);
    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
