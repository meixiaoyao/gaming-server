package com.ooqiu.gaming.server.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Title: ${CLASS_NAME} </p>
 * <p>Description: </p>
 *
 * @author Eve
 * @version 1.0.0
 * @date 上午 9:53 2018/3/1 0001
 */
@Controller
public class LoginController {

    /**
     *跳转登录页
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 跳转主页
     * @return
     */
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String email, String password){
        if("admin@admin.com".equals(email) && "admin".equals(password)){
            return "redirect:main";
        }else{
            return "login";
        }
    }
}
