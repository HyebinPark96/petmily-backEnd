package com.example.demo.controller.api;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiRestController {
    @Autowired
    UserService userService;

    @PostMapping("/user/signUp")
    public boolean signUpProc(@RequestBody UserDTO userDTO){
        return userService.signUpProc(userDTO);
    }

    @PostMapping("/user/signIn")
    public boolean signInProc(@RequestBody UserDTO userDTO){
        return userService.signInProc(userDTO);
    }

}

