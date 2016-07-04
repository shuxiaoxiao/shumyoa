package com.shupro.oa.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录退出
 * @author shu
 *
 */
@Controller
//@RequestMapping("/")
public class PageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);
    
    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/tologin")
    public String tologin(Model model) {
        return "/login";
    }
    
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
