package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by H1N1 on 2019-12-31.
 */
@Controller
@RequestMapping("/sys")
public class SystemController {

    private final static Logger logger = LoggerFactory.getLogger(SystemController.class);

    /**
     *跳转到登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin()
    {
        logger.info("toLogin");
        return "system/index/login";
    }
}
