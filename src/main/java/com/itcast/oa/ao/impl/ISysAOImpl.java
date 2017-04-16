package com.itcast.oa.ao.impl;

import com.itcast.oa.ao.ISysAO;
import com.itcast.oa.domain.User;
import com.itcast.oa.service.IUserService;
import com.itcast.oa.service.req.F1001Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ichoice on 2017/2/25.
 */
@Service
public class ISysAOImpl implements ISysAO {
    @Autowired
    private IUserService userService;


    public Long doSysUserLogin(String loginName, String loginPwd) {
        F1001Req f1001Req=new F1001Req();
        f1001Req.setLoginName(loginName);
        f1001Req.setLoginPwd(loginPwd);
        User user= userService.getUserByName(f1001Req);
        return user.getId();
    }
}
