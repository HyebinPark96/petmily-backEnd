package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean signUpProc(UserDTO userDTO){
        Integer result = userMapper.signUpProc(userDTO);
        return result == 1;
    }

    public boolean signInProc(UserDTO userDTO){
        Integer result = userMapper.signInProc(userDTO);
        return result == 1;
    };

    public boolean checkUserId(UserDTO userDTO){
        Integer result = userMapper.checkUserId(userDTO);
        return result == 1;
    };

}
