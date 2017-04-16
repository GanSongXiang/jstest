package com.itcast.oa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ichoice on 2017/2/18.
 */
@Controller
@RequestMapping("/freeMark")
public class FreeMarkController{

    @RequestMapping("/test")
    public ModelAndView handleRequest(HttpServletRequest hsr
            , HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("oss/index");
        mv.addObject("title", "Spring MVC And Freemarker");
        mv.addObject("content", "test my first spring mvc ! ");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest hsr
            , HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("/screen/login");
        mv.addObject("title", "Spring MVC And Freemarker");
        mv.addObject("content", "test my first spring mvc ! ");
        return mv;
    }
}
