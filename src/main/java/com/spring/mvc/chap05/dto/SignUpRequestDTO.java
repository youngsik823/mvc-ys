package com.spring.mvc.chap05.dto;

import lombok.*;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
public class SignUpRequestDTO {

    private String account;
    private String password;
    private String name;
    private String email;
}
