package com.itcast.oa.service;

import com.itcast.oa.base.service.IBaseService;
import com.itcast.oa.domain.User;
import com.itcast.oa.service.req.F1001Req;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Created by ichoice on 2017/2/17.
 */
@ServiceMode
public interface IUserService extends IBaseService<User>{
    User getUserByName(F1001Req f1001Req);

    List<User> getAll();

    int getByLoginName(String loginName);
}
