package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("com.example.demo.mapper.UserMapper") // XML 위치
@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용가능
public interface UserMapper {
    // 회원가입
    Integer signUpProc(UserDTO userDTO);

    // 로그인
    Integer signInProc(UserDTO userDTO);
}

