package com.example.demo.dto;

import com.example.demo.dto.common.InsertCheck;
import com.example.demo.dto.common.SelectCheck;
import com.example.demo.dto.common.UpdateCheck;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserDTO {

    /** 아이디 **/
    @Size(min = 5, max = 14, message = "아이디는 5 ~ 14자여야 합니다.")
    @NotBlank(groups = {SelectCheck.class, InsertCheck.class}, message = "아이디는 null 또는 빈 값이 허용되지 않습니다.")
    private String userId;

    /** 비밀번호 **/
    @Size(min = 8, max = 14, message = "비밀번호는 8 ~ 14자여야 합니다.")
    @NotBlank(groups = {InsertCheck.class, UpdateCheck.class}, message = "비밀번호는 null 또는 빈 값이 허용되지 않습니다.")
    private String password;

    /** 이름 **/
    @Size(min = 1, max = 10, message = "이름은 1 ~ 10자여야 합니다.")
    @NotBlank(groups = {InsertCheck.class, UpdateCheck.class}, message = "이름은 null 또는 빈 값이 허용되지 않습니다.")
    private String name;

    /** 이메일 **/
    @Email(groups = {InsertCheck.class, UpdateCheck.class}, message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(groups = {InsertCheck.class, UpdateCheck.class}, message = "이메일은 null 또는 빈 값이 허용되지 않습니다.")
    private String email;

    /** 성별 **/
    private Long gender;

}