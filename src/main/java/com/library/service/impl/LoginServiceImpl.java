package com.library.service.impl;

import com.library.dao.LoginMapper;
import com.library.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    //login dao
    private LoginMapper loginMapper;

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public int login(String username, String password) {
        return loginMapper.login(username,password);
    }

    @Override
    public void register(String username,String password) {
        loginMapper.register(username,password);
    }
}
