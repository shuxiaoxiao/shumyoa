package com.shupro.oa.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录退出
 * @author shu
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

//    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    
    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/home")
    public String home(Model model) {
        return "/home";
    }
    
    /**
     * 欢迎页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/welcome")
    public String welcome(Model model) {
    	return "/welcome";
    }


    
}
