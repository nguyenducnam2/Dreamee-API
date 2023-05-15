package org.dreameeapi.controller;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.dto.UserDto;
import org.dreameeapi.entity.User;
import org.dreameeapi.response.MessResponse;
import org.dreameeapi.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public MessResponse save(@RequestBody UserDto userDto) {
        try {
            userService.save(userDto.get());
            return new MessResponse(true, "Successfully");
        } catch (Exception e) {
            return new MessResponse(false, e.getMessage());
        }
    }

}
