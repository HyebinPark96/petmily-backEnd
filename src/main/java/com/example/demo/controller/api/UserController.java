package com.example.demo.controller.api;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.common.InsertCheck;
import com.example.demo.dto.common.SelectCheck;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/signUp")
    public boolean signUpProc(@Validated(InsertCheck.class) @RequestBody UserDTO userDTO){
        return userService.signUpProc(userDTO);
    }

    @PostMapping("/user/signIn")
    public boolean signInProc(@Validated(SelectCheck.class) @RequestBody UserDTO userDTO){
        return userService.signInProc(userDTO);
    }

    @PostMapping("/user/checkUserId")
    public boolean checkUserId(@Validated(SelectCheck.class) @RequestBody UserDTO userDTO){
        return userService.checkUserId(userDTO);
    }
}

