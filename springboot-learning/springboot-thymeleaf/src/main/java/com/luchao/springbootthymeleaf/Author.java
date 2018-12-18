package com.luchao.springbootthymeleaf;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;

public class Author {
    /**
     * @NotEmpty 用在集合类上面
     * @NotBlank 用在String上面
     * @NotNull 用在基本类型上
     */
    @NotNull(message = "年龄不能为空！")
    @Min(value = 15)
    @Max(value = 100)
    private Integer age;
    @NotBlank(message = "姓名不能为空！")
    private String username;
    @Email
    @NotBlank
    private String email;
    @NotNull(message = "手机号不能为空！")
    @Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$",message = "手机号错误！")
    private String telphone;

    @Override
    public String toString() {
        return "Author{" +
                "age=" + age +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telphone='" + telphone + '\'' +
                '}';
    }
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
