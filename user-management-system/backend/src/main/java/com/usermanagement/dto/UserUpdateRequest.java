package com.usermanagement.dto;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserUpdateRequest {

    @Email(message = "邮箱格式不正确")
    private String email;

    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    private String fullName;
    private String avatar;
    private String bio;
    private Long departmentId;

    @Size(min = 6, max = 20, message = "密码长度必须在6-20之间")
    private String password;

    private List<Long> roleIds;
}
