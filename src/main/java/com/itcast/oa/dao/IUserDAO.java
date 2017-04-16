package com.itcast.oa.dao;

import com.itcast.oa.base.dao.func.IEntityDAO;
import com.itcast.oa.domain.User;

import java.util.List;

public interface IUserDAO extends IEntityDAO<User, User> {
    List<User> getAll();

    int getByLoginName(String loginName);
}