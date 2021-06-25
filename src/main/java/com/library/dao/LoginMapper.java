package com.library.dao;


import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

    int login(@Param("username") String username,@Param("password") String password);

    void register(@Param("username") String username,@Param("password") String password);
}
