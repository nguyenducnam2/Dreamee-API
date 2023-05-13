package org.dreameeapi.controller;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.entity.User;
import org.dreameeapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

}
