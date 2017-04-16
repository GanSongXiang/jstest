package com.itcast.oa.controller;

import com.itcast.oa.ao.ISysAO;
import com.itcast.oa.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by ichoice on 2017/2/25.
 */
@Controller
public class SysController extends BaseController{
    @Autowired
    private ISysAO sysAO;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean sysUserLogin(HttpSession session,
                                @RequestParam("login_name") String loginName,
                                @RequestParam("login_pwd") String loginPwd) {
        //Long userId = sysAO.doSysUserLogin(loginName, loginPwd);

        // 存oss用户session
        //SessionUser sessionOssUser = SessionHelper.setOssIdentity(userId);
        //sessionProvider.setOssUserDetail(sessionOssUser);
        session.setAttribute("userName","admin");
        return true;
    }
}
