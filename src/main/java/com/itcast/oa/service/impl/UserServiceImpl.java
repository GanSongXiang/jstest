package com.itcast.oa.service.impl;

import com.itcast.oa.base.service.impl.BaseService;
import com.itcast.oa.dao.IPersonDAO;
import com.itcast.oa.dao.IUserDAO;
import com.itcast.oa.domain.User;
import com.itcast.oa.service.IUserService;
import com.itcast.oa.service.req.F1001Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ichoice on 2017/2/17.
 */
@Service("UserService")
public class UserServiceImpl extends BaseService<User> implements IUserService {
    private IUserDAO userDAO;

    @Autowired
    public void setEntityDAO(IUserDAO userDAO) {
        this.userDAO=userDAO;
        super.setDao(userDAO);
    }

    public User getUserByName(F1001Req f1001Req) {
        return null;
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public int getByLoginName(String loginName) {
        return userDAO.getByLoginName(loginName);
    }
}
