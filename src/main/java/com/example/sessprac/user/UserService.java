package com.example.sessprac.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public UserJoinDTO joinUser(UserJoinDTO userDto){
        try{
            userMapper.joinUser(userDto);
            return userDto;
        }catch (Exception e){
            return null;
        }

    }

}
