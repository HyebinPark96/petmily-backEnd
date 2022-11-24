package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean signUpProc(UserDTO userDTO){
        Integer result = userMapper.signUpProc(userDTO);
        if(result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean signInProc(UserDTO userDTO){
        Integer result = userMapper.signInProc(userDTO);
        if(result == 1) {
            return true;
        } else {
            return false;
        }
    };

}
