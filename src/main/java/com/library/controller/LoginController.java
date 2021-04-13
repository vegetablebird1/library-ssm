package com.library.controller;

import com.library.pojo.User;
import com.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        int result = loginService.login(username,password);
        User user;
        if(result == 1 && "admin".equals(username)){
            session.setAttribute("flag",true);
            return "redirect:book/allBook";//管理员进入主页面
        }else if(result == 1){
            session.setAttribute("flag",true);
            user = new User(username,password);
            session.setAttribute("user",user);
            return "redirect:borrow/allBook";//其他用户进入预览页面
        }
        //密码错误，重新登录
        session.setAttribute("flag",false);
        return "login_Error";
    }

    //注册成功后，进入图书馆页面
    @RequestMapping("/register")
    public String register(String username,String password,HttpSession session){
        loginService.register(username,password);
        User user = new User(username,password);
        session.setAttribute("flag",true);
        session.setAttribute("user",user);
        return "redirect:/borrow/allBook";
    }
}
