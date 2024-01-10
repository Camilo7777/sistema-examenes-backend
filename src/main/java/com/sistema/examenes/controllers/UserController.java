package com.sistema.examenes.controllers;

import com.sistema.examenes.models.Rol;
import com.sistema.examenes.models.User;
import com.sistema.examenes.models.UserRol;
import com.sistema.examenes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        Set<UserRol> userRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setId(2L);
        rol.setRolName("NORMAL");

        UserRol userRol = new UserRol();
        userRol.setUser(user);
        userRol.setRol(rol);

        userRoles.add(userRol);

        return userService.saveUser(user,userRoles);
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName) {
        return userService.getUser(userName);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
         userService.deleteUser(userId);
    }


}
