package com.sistema.examenes.services;

import com.sistema.examenes.models.User;
import com.sistema.examenes.models.UserRol;

import java.util.Set;

public interface UserService {
    public User saveUser(User user, Set<UserRol> userRolSet) throws Exception;

    public User getUser(String userName);

    public void deleteUser(Long userId);
}
