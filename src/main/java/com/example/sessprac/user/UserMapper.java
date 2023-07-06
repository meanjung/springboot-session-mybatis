package com.example.sessprac.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void joinUser(UserJoinDTO dto);
}
