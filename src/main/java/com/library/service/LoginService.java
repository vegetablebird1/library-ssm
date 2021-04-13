package com.library.service;

public interface LoginService {
    int login(String username,String password);

    void register(String username,String password);
}
