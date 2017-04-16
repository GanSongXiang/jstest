package com.itcast.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ichoice on 2017/2/26.
 */
@Controller
public class PageController {
    @RequestMapping(value = "/{first}/{page}.htm", method = RequestMethod.GET)
    public String commonPage1Action(@PathVariable String first, @PathVariable String page) {
        return first + "/" + page;
    }

    @RequestMapping(value = "/{first}/{second}/{page}.htm", method = RequestMethod.GET)
    public String commonPage2Action(@PathVariable String first, @PathVariable String second, @PathVariable String page) {
        return first + "/" + second + "/" + page;
    }
}
