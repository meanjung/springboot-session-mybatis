package com.example.sessprac.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserJoinDTO {
    private String userId;
    private String userName;
    private String userPasswd;

}
