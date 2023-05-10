package com.spring.mvc.chap05.dto;

import lombok.*;

@Setter @Getter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class LoginRequestDTO {

    private String account;
    private String password;
    private boolean autoLogin;
}
